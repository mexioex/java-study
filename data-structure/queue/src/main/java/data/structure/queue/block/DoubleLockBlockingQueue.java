package data.structure.queue.block;

import data.structure.BlockingQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁阻塞队列,单锁解决了并发安全
 * 但是入队和出队用的是一把锁,
 * 入队线程执行,出队线程就需要等待
 * 出队线程执行,入队线程就需要等待
 * 理论上来说入队跟出队应该互不干扰,但是单锁解决不了这个问题
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class DoubleLockBlockingQueue<E> implements BlockingQueue<E> {
    private final E[] array;
    private int head;
    private int tail;
    private final AtomicInteger size;
    private final ReentrantLock headLock = new ReentrantLock();
    private final Condition headWaits = headLock.newCondition();
    private final ReentrantLock tailLock = new ReentrantLock();
    private final Condition tailWaits = tailLock.newCondition();

    @Override
    public void offer(E e) throws InterruptedException {
        int current;
        tailLock.lockInterruptibly();
        try {
            // 队列满则等待
            while (isFull()) {
                tailWaits.await();
            }
            // 不满则入队
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            /*
                1.读取成员变量size的值
                2.自增
                3.写回size
                这个操作线程不安全的
             */
            // 修改 size 等价于 size++
            current = size.incrementAndGet();
            // 如果 offer 的元素放进队列中,队列中还有空位,就由 offer 唤醒 poll
            if (current + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }
        // 如果 offer 放了元素,还是被拿走了,就由 offer 唤醒 offer 线程
        if (current == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        int current;
        E e;
        headLock.lockInterruptibly();
        try {
            // 队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }
            // 队列非空则出队
            e = array[head];
            // help gc
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            // 修改size
            /*
                1.读取成员变量size的值
                2.自减
                3.写回size
                这个操作线程不安全的
             */
            // 修改 size 等价于 size--
            current = size.getAndDecrement();
            // poll 拿完还剩下,就由 poll 去唤醒 offer 线程
            if (current > 1) {
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }
        // 队列元素是满的,由 poll 线程 唤醒 poll 线程
        if (current == array.length) {
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        return null;
    }

    @Override
    public E peek() throws InterruptedException {
        return null;
    }

    @Override
    public E peek(long timeout) throws InterruptedException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size.get() == 0;
    }

    @Override
    public boolean isFull() {
        return size.get() == array.length;
    }

    @SuppressWarnings("all")
    public DoubleLockBlockingQueue(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.size = new AtomicInteger(0);
        this.head = 0;
        this.tail = 0;
    }
}
