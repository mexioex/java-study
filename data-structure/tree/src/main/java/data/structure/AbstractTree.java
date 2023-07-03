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

    /**
     * 判断当前节点是否是红色
     *
     * @param node 需要判断是否需要判断的节点
     * @return 红色返回true, 其他返回false
     */
    protected boolean isRed(Node<K, V> node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    /**
     * 判断当前节点是否是黑色
     *
     * @param node 需要判断是否需要判断的节点
     * @return 红色返回false, 其他或者null返回true
     */
    protected boolean isBlack(Node<K, V> node) {
        if (node == null) {
            return true;
        }
        return node.color == Color.BLACK;
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
     * 红黑树颜色枚举
     */
    protected enum Color {
        RED, BLACK
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
        /**
         * 平衡树使用
         */
        public int height;
        /**
         * 红黑树使用
         */
        public Color color = Color.RED;
        /**
         * 红黑树使用
         */
        public Node<K, V> parent;

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

        /**
         * 仅提供给红黑树使用
         * 是否左孩子
         *
         * @return 父节点不为空, 并且是父节点的left返回true, 否则返回false
         */
        public boolean isLeft() {
            return parent != null && parent.left == this;
        }

        /**
         * 获取父节点的兄弟节点
         *
         * @return 如果父节点是左孩子, 返回父节点的父节点的右孩子, 如果父节点是右孩子, 返回父节点的父节点的左孩子
         */
        public Node<K, V> getParentSibling() {
            if (parent == null) {
                return null;
            }
            if (parent.parent == null) {
                return null;
            }
            if (parent.isLeft()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        /**
         * 获取当前节点的兄弟节点
         *
         * @return 如果当前是左孩子返回父节点的右孩子, 如果当前是右孩子返回父节点的左孩子
         */
        public Node<K, V> getSibling() {
            if (parent == null) {
                return null;
            }
            if (this.isLeft()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }
}
