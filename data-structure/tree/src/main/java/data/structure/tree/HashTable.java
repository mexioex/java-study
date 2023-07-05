package data.structure.tree;

import data.structure.Tree;

/**
 * 哈希表实现
 *
 * @author mexioex
 * @date 2023-07-05
 */
public class HashTable<K extends Comparable<K>, V> implements Tree<K, V> {
    /**
     * 存放头节点的数组
     */
    @SuppressWarnings("unchecked")
    private Node<K, V>[] table = (Node<K, V>[]) new Node<?, ?>[16];
    /**
     * 元素个数
     */
    private int size = 0;
    /**
     * 负载因子
     */
    private final float loadFactor = 0.75f;
    /**
     * 阈值,size大于等于阈值就需要resize
     */
    private int threshold = (int) (table.length * loadFactor);

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        return doGet(key.hashCode(), key);
    }

    /**
     * 根据哈希码获取 value
     *
     * @param hash 哈希码
     * @param key  键
     * @return value
     */
    private V doGet(int hash, K key) {
        // 获取 key 的索引
        int index = getIndex(hash, table.length);
        // 索引处没有元素返回 null
        if (table[index] == null) {
            return null;
        }
        Node<K, V> kvNode = table[index];
        while (kvNode != null) {
            if (kvNode.hash == hash) {
                return kvNode.value;
            }
            if (kvNode.key.equals(key)) {
                return kvNode.value;
            }
            kvNode = kvNode.next;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        doPut(key.hashCode(), key, value);
    }

    /**
     * 向哈希表中插入 key value
     *
     * @param hash  哈希码
     * @param key   键
     * @param value 值
     */
    private void doPut(int hash, K key, V value) {
        int index = getIndex(hash, table.length);
        // table[index] 没有元素就新建
        if (table[index] == null) {
            table[index] = new Node<>(hash, key, value);
        } else {
            // 有元素,沿着链表查找,有重复 key 就更新,没有就新增
            Node<K, V> kvNode = table[index];
            while (true) {
                // 相同则更新
                if (kvNode.key.equals(key)) {
                    kvNode.value = value;
                    return;
                }
                // 没有下一个,则当前节点的下一个就是要插入的位置
                if (kvNode.next == null) {
                    break;
                }
                kvNode = kvNode.next;
            }
            // 当前节点的下一个就是新插入的节点
            kvNode.next = new Node<>(hash, key, value);
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    /**
     * 当远哥个数达到阈值时进行扩容
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] newTable = (Node<K, V>[]) new Node<?, ?>[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            // 获取链表头
            Node<K, V> kvNode = table[i];
            if (kvNode != null) {
                /*
                1.拆分链表移动到新数组
                2.一个链表最多拆分两个
                3. hash & table.length == 0 一组
                3. hash & table.length != 0 一组
                 */
                // 拆分后的链表 a
                Node<K, V> a = null;
                // 拆分后的链表 b
                Node<K, V> b = null;
                // a 链表的头指针
                Node<K, V> aHead = null;
                // b 链表的头指针
                Node<K, V> bHead = null;
                while (kvNode != null) {
                    if ((kvNode.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = kvNode;
                        } else {
                            aHead = kvNode;
                        }
                        a = kvNode;
                    } else {
                        if (b != null) {
                            b.next = kvNode;
                        } else {
                            bHead = kvNode;
                        }
                        b = kvNode;
                    }
                    kvNode = kvNode.next;
                }
                /*
                1.当分成a,b两个链表之后,最后一个元素可能回到循环链表所有要做一下操作
                0 —> 8 —> 16 —> 32 —> 40 —> 48
                a = 0 —> 16 —> 32 —> 48
                b = 8 —> 24 —> 40
                原来 40 的元素只想的 48 如果回收掉将会导致循环链表
                 */
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    @Override
    public V remove(K key) {
        return doRemove(key.hashCode(), key);
    }

    /**
     * 根据哈希码删除
     *
     * @param hash key 的哈希码
     * @param key  key
     * @return 被删除的值
     */
    private V doRemove(int hash, K key) {
        int index = getIndex(hash, table.length);
        if (table[index] == null) {
            return null;
        }
        Node<K, V> kvNode = table[index];
        Node<K, V> prev = null;
        while (kvNode != null) {
            if (kvNode.key.equals(key)) {
                if (prev == null) {
                    table[index] = kvNode.next;
                } else {
                    prev.next = kvNode.next;
                }
                size--;
                return kvNode.value;
            }
            prev = kvNode;
            kvNode = kvNode.next;
        }
        return null;
    }

    /**
     * 求模运算过于抵消,如果能够保证 table 的长度是 2 的 n 次方
     * hash & 数组长度 等价于 hash & (数组长度 - 1)
     *
     * @param hash   插入的键的hash码
     * @param length table 的长度
     * @return key 在 table 中的索引
     */
    private int getIndex(int hash, int length) {
        return hash & (length - 1);
    }

    static class Node<K, V> {
        /**
         * 哈希码
         */
        int hash;

        /**
         * 键
         */
        K key;

        /**
         * 值
         */
        V value;

        /**
         * 相同哈希码的下一个键值对
         */
        Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
