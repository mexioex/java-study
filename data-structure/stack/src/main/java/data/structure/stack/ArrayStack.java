package data.structure.stack;

import data.structure.Stack;

import java.util.Iterator;

/**
 * 数组栈实现
 *
 * @author mexioex
 * @date 2023-06-13
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private final E[] array;
    private int top;

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = top;

            @Override
            public boolean hasNext() {
                return p == 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }
}
