package data.structure.queue.single;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 环形数组队列
 * 这种方式的缺点是会废弃掉一个数组元素的位置
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        // 尾指针循环,达到边界就归零
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        // 头尾指针相等队列是空的
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // 尾节点+1跟对数组长度取模等于head,头指针相等,队列已满
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }

    @SuppressWarnings("all")
    public CircleArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }
}