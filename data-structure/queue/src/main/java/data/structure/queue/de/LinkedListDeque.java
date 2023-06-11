package data.structure.queue.de;

import data.structure.Deque;

import java.util.Iterator;

/**
 * 双端链表队列
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {
    /**
     * 哨兵节点
     */
    private final Node<E> sentinel = new Node<>(null, null, null);
    /**
     * 队列容量
     */
    private final int capacity;
    /**
     * 队列元素个数
     */
    private int size;

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> prev = sentinel;
        Node<E> next = sentinel.next;
        Node<E> added = new Node<>(prev, value, next);
        prev.next = added;
        next.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> prev = sentinel.prev;
        Node<E> next = sentinel;
        Node<E> added = new Node<>(prev, value, next);
        prev.next = added;
        next.prev = added;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> prev = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> next = removed.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> next = sentinel;
        Node<E> removed = sentinel.prev;
        Node<E> prev = removed.prev;
        prev.next = next;
        next.prev = prev;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> node = sentinel.next;

            @Override
            public boolean hasNext() {
                return node != sentinel;
            }

            @Override
            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    private static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
