package data.structure.queue.single;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 环形数组队列
 * 使用size判断队列满或者空
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayQueue2<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;
    private int size;

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        // 尾指针循环,达到边界就归零
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        // 头指针循环,达到边界就归零
        head = (head + 1) % array.length;
        size--;
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
        // 队列中元素个数为0,队列为空
        return size == 0;
    }

    @Override
    public boolean isFull() {
        // 元素个数和数组长凳相等,队列已满
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
                return value;
            }
        };
    }

    @SuppressWarnings("all")
    public CircleArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }
}