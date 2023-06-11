package data.structure.queue.block;

import data.structure.BlockingQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单所阻塞队列实现
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class SingleLockBlockingQueue<E> implements BlockingQueue<E> {
    private final E[] array;
    private int head;
    private int tail;
    private int size;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition headWaits = lock.newCondition();
    private final Condition tailWaits = lock.newCondition();

    @Override
    public void offer(E e) throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            // 队列已满,入队就等待
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            // 唤醒登台出队的线程
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MICROSECONDS.toNanos(timeout);
            // 队列已满,入队就等待
            while (isFull()) {
                // 虚假唤醒
                if (t <= 0) {
                    return false;
                }
                // 最多等待多少纳秒,返回值代表剩余等待时间
                t = tailWaits.awaitNanos(t);
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            // 唤醒等待出队的线程
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            // 队列已满,出队就等待
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            // help gc
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MICROSECONDS.toNanos(timeout);
            // 队列已满,出队就等待
            while (isEmpty()) {
                // 虚假唤醒
                if (t <= 0) {
                    return null;
                }
                t = headWaits.awaitNanos(t);
            }
            E e = array[head];
            // help gc
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E peek() throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            // 队列为空,出队就等待
            while (isEmpty()) {
                headWaits.await();
            }
            return array[head];
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E peek(long timeout) throws InterruptedException {
        // 可中断加锁
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MICROSECONDS.toNanos(timeout);
            // 队列为空,出队就等待
            while (isEmpty()) {
                // 虚假唤醒
                if (t <= 0) {
                    return null;
                }
                t = headWaits.awaitNanos(t);
            }
            return array[head];
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @SuppressWarnings("all")
    public SingleLockBlockingQueue(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }
}
