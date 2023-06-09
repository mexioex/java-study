package data.structure.linked;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向哨兵环形链表实现
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class CircleDoubleLinkedList implements Iterable<Integer> {
    /**
     * 哨兵节点
     */
    private final Node sentinel;

    /**
     * 添加到第一个
     *
     * @param value 待添加的值
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(value, a, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     *
     * @param value 待添加的值
     */
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(value, a, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node first = sentinel;
        Node next = removed.next;
        first.next = next;
        next.prev = first;
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除
     *
     * @param value 待删除的值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 根据值查找节点
     *
     * @param value 查找的值
     * @return 值所在节点
     */
    private Node findByValue(int value) {
        Node node = sentinel.next;
        while (node != sentinel) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 根据索引删除
     *
     * @param index 待删除的索引
     */
    public void remove(int index) {
        Node removed = findByIndex(index);
        if (removed == null) {
            return;
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 根据索引查找节点
     *
     * @param index 查找的索引
     * @return 索引对应的节点
     */
    private Node findByIndex(int index) {
        int i = 0;
        Node node = sentinel.next;
        while (node != sentinel) {
            if (i == index) {
                return node;
            }
            i++;
            node = node.next;
        }
        return null;
    }

    /**
     * 根据索引获取
     *
     * @param index 待查询的索引
     * @return 索引处节点的值
     */
    public int get(int index) {
        Node node = findByIndex(index);
        if (node != null) {
            return node.value;
        } else {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
    }

    /**
     * 指定索引处插入
     *
     * @param index 待插入的索引
     * @param value 索引处的值
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node node = findByIndex(index);
        if (node != null) {
            Node prev = node.prev;
            Node next = node.next;
            Node inserted = new Node(value, prev, next);
            prev.next = inserted;
            next.prev = inserted;
        } else {
            throw new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
        }
    }

    public CircleDoubleLinkedList() {
        this.sentinel = new Node(-1, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node node = sentinel.next;

            @Override
            public boolean hasNext() {
                return node != sentinel;
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
        for (Node node = sentinel.next; node != sentinel; node = node.next) {
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
