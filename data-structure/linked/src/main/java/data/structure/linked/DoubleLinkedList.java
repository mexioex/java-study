package data.structure.linked;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向链表实现
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class DoubleLinkedList implements Iterable<Integer> {
    /**
     * 头节点
     */
    private final Node head;
    /**
     * 尾节点
     */
    private final Node tail;

    public DoubleLinkedList() {
        this.head = new Node(-1, null, null);
        this.tail = new Node(-1, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(value, last, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", 0));
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     * 根据索引位置找到节点
     *
     * @param index 待查询索引
     * @return 索引处的节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node node = head; node != tail; node = node.next, i++) {
            if (i == index) {
                return node;
            }
        }
        return null;
    }

    /**
     * 在指定索引处插入一个新的节点
     *
     * @param index 待插入的索引
     * @param value 待插入的值
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
        Node next = prev.next;
        Node inserted = new Node(value, prev, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * 删除指定索引处的节点
     *
     * @param index 待删除索引
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int index) {
        Node node = findNode(index - 1);
        if (node == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
        return node.value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node node = head.next;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public Integer next() {
                int value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (Node node = head.next; node != tail; node = node.next) {
            action.accept(node.value);
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        /**
         * 节点值
         */
        int value;
        /**
         * 上一个节点指针
         */
        Node prev;
        /**
         * 下一个节点指针
         */
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
