package data.structure.queue.priority;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 无序数组实现优先队列
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class PriorityQueue1<E extends Priority> implements Queue<E>, Iterable<E> {
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
        array[size++] = value;
        return true;
    }

    private int selectMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        @SuppressWarnings("unchecked")
        E e = (E) array[max];
        remove(max);
        return e;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
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

    public PriorityQueue1(int capacity) {
        this.array = new Priority[capacity];
        this.size = 0;
    }
}
