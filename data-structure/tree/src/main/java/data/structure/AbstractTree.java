package data.structure;

/**
 * @author mexioex
 * @date 2023-06-26
 */
public abstract class AbstractTree<K extends Comparable<K>, V> implements Tree<K, V> {
    /**
     * 根节点
     */
    protected Node<K, V> root;

    /**
     * 树的元素个数
     */
    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract Node<K, V> getNode(K key);

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        Node<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    /**
     * 节点类
     *
     * @param <K> 节点的 key
     * @param <V> 节点的 value
     */
    protected static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> left;
        public Node<K, V> right;

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
