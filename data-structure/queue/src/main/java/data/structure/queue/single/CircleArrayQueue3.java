package data.structure.queue.single;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 环形数组队列
 * tail与head永远自增
 * 通过head和tail取模,计算数组索引
 * 对于求模运算,
 * 如果除数是 2 的 n 次方,那么被除数的后 n 位就是余数
 * 求被除数的后 n 位: 与 2^n-1 做逻辑和
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail & array.length - 1] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head & array.length - 1];
    }

    @Override
    public boolean isEmpty() {
        // 首位相等队列是空的
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // 尾减去头的值,与数组长度一致,则队列已满
        return tail - head == array.length;
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
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }

    @SuppressWarnings("all")
    public CircleArrayQueue3(int capacity) {
        capacity -= 1;
        capacity |= capacity >> 1;
        capacity |= capacity >> 2;
        capacity |= capacity >> 4;
        capacity |= capacity >> 6;
        capacity |= capacity >> 8;
        capacity |= capacity >> 16;
        capacity += 1;
        array = (E[]) new Object[capacity];
    }
}