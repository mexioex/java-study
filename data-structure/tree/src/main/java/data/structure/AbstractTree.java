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

    protected Node<K, V> getNode(K key) {
        Node<K, V> node = root;
        while (node != null) {
            int comparedTo = key.compareTo(node.key);
            switch (comparedTo) {
                case -1 -> node = node.left;
                case 0 -> {
                    return node;
                }
                case 1 -> node = node.right;
                default -> throw new IllegalStateException("state: " + comparedTo);
            }
        }
        return null;
    }

    /**
     * 获取节点高度,如果高度等于null节点高度就是0
     *
     * @param node 目标节点
     * @return 节点在树中的高度
     */
    protected int getHeight(Node<K, V> node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 更新节点的高度,节点的高度是起左子树与右子树的大的值+1
     *
     * @param node 更新的节点
     */
    protected void setHeight(Node<K, V> node) {
        int leftChildHeight = getHeight(node.left);
        int rightChildHeight = getHeight(node.right);
        node.height = Integer.max(leftChildHeight, rightChildHeight) + 1;
    }

    /**
     * 平衡银子,左子树高度减去右子树高度
     * balanceFactor = 0,平衡
     * balanceFactor > 1,左边高
     * balanceFactor < -1,右边高
     *
     * @param node 获取平衡影子的节点
     * @return 当前树的左右子树的差
     */
    protected int geBalanceFactor(Node<K, V> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

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
        public int height;

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
