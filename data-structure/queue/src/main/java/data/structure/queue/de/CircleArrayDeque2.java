package data.structure.queue.de;

import data.structure.Deque;

import java.util.Iterator;

/**
 * 循环数组双端口队列
 * 特点: 引入size变量用于判空或满
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayDeque2<E> implements Deque<E>, Iterable<E> {
    private final E[] array;
    private int head;
    private int tail;
    private int size;

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        head = dec(head, array.length);
        array[head] = value;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = inc(tail, array.length);
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        array[head] = null;
        head = inc(head, array.length);
        size--;
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail, array.length);
        E value = array[tail];
        array[tail] = null;
        size--;
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(tail, array.length)];
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

            @Override
            public E next() {
                E value = array[p];
                p++;
                return value;
            }
        };
    }

    /**
     * @param i      当前索引
     * @param length 数组长度
     * @return i+1大于等于 length 归零,否则+1
     */
    static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    /**
     * @param i      当前索引
     * @param length 数组长度
     * @return i-1 小于 0 返回数组长度-1,否则+1
     */
    static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    @SuppressWarnings("all")
    public CircleArrayDeque2(int capacity) {
        array = (E[]) new Object[capacity];
    }
}