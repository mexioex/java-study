package data.structure.linked;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单项链表实现
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SingleLinkedList implements Iterable<Integer> {
    /**
     * 头节点
     */
    private Node head;

    /**
     * 头部添加
     *
     * @param value 添加的值
     */
    public void addFirst(int value) {
        // 新节点等于头节点,原来的头节点变成新节点的下一个节点
        head = new Node(value, head);
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last != null) {
            last.next = new Node(value, null);
        } else {
            addFirst(value);
        }
    }

    /**
     * 最后一个节点的下一个是null
     *
     * @return 最后一个节点
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 根据索引查找元素
     *
     * @param index 目标索引
     * @return 索引处节点的值
     */
    public int get(int index) {
        return findNode(index).value;
    }

    /**
     * 在指定索引处插入一个元素
     *
     * @param value 要插入的位置
     * @param index 要插入的节点位置
     */
    public void insert(int value, int index) {
        if (index == 0) {
            addFirst(value);
        } else {
            Node prev = findNode(index - 1);
            prev.next = new Node(value, prev.next);
        }
    }

    /**
     * 删除第一个节点,只需要让 head 指向 head.next
     */
    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", 0));
        }
        head = head.next;
    }

    /**
     * 删除指定索引的节点
     *
     * @param index 待删除索引
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        // 被删除节点的前一个节点
        Node prev = findNode(index - 1);
        // 被删除节点
        Node removed = prev.next;
        if (removed == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", 0));
        }
        // 前一个节点指向删除节点的下一个节点
        prev.next = removed.next;
    }

    /**
     * 根据索引查找节点
     *
     * @param index 元素在链表中的节点
     * @return 第 index 个节点
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node node = head; node != null; node = node.next, i++) {
            if (index == i) {
                return node;
            }
        }
        throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
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
        for (Node node = head; node != null; node = node.next) {
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
         * 下一个节点指针
         */
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

