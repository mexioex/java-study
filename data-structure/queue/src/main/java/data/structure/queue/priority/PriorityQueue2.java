package data.structure.queue.priority;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 有序数组实现优先队列
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class PriorityQueue2<E extends Priority> implements Queue<E>, Iterable<E> {
    /**
     * 元素数组
     */
    private final Priority[] array;
    /**
     * 元素个数
     */
    private int size;

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    /**
     * 入队时,根据优先级排队
     *
     * @param value 入队元素
     */
    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E e = (E) array[size - 1];
        array[--size] = null;
        return e;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = 0;

            @Override
            public boolean hasNext() {
                return p < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                Priority priority = array[p];
                p++;
                return (E) priority;
            }
        };
    }

    public PriorityQueue2(int capacity) {
        this.array = new Priority[capacity];
        this.size = 0;
    }
}
