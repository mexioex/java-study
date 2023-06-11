package data.structure.queue.single;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 单向环形链表实现队列
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
    /**
     * 头节点
     */
    private final Node<E> head = new Node<>(null, null);
    /**
     * 尾节点
     */
    private Node<E> tail = head;
    /**
     * 节点数
     */
    private int size;
    /**
     * 容量
     */
    private int capacity = Integer.MAX_VALUE;

    @Override
    public boolean offer(E value) {
        // 满了不允许入队
        if (isFull()) {
            return false;
        }
        // 新节点的下一个指向头节点
        Node<E> added = new Node<>(value, head);
        // 尾节点的下一个指向新节点
        tail.next = added;
        // 尾节点变成被插入的节点
        tail = added;
        // 元素个数+1
        size++;
        return true;
    }

    @Override
    public E poll() {
        // 为空不允许出队
        if (isEmpty()) {
            return null;
        }
        // 哨兵的下一个节点就是出队的节点
        Node<E> first = head.next;
        // 删除被出队的节点
        head.next = first.next;
        // 如果出队的是尾节点,让尾节点称为哨兵
        if (first == tail) {
            tail = head;
        }
        // 元素个数-1
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        // 为空返回null
        if (isEmpty()) {
            return null;
        }
        // 队首第一个元素,就是哨兵的下一个
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        // 首尾都是哨兵则队列为空
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // 节点个数与元素相等队列已满
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> node = head.next;

            @Override
            public boolean hasNext() {
                return node != head;
            }

            @Override
            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public LinkedListQueue() {
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    {
        tail.next = head;
        size = 0;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
