package data.structure.tree;

import data.structure.AbstractTree;

/**
 * 二叉搜索树实现
 *
 * @author mexioex
 * @date 2023-06-26
 */
public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractTree<K, V> {

    @Override
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
     * 获取树中最大值
     *
     * @return 最大值, 存在返回值, 不存在返回null
     */
    public V getMax() {
        if (isEmpty()) {
            return null;
        }
        Node<K, V> maxNode = getMaxNode(root);
        if (maxNode == null) {
            return null;
        }
        return maxNode.value;
    }

    /**
     * 获取树中最大节点
     *
     * @param root 要查找的树的根节点
     * @return 最大值所在的节点, 存在返回节点, 不存在返回null
     */
    private Node<K, V> getMaxNode(Node<K, V> root) {
        Node<K, V> node = root;
        while (node != null) {
            if (node.right == null) {
                return node;
            }
            node = node.right;
        }
        return null;
    }

    /**
     * 获取树中最小值
     *
     * @return 最小值, 存在返回值, 不存在返回null
     */
    public V getMin() {
        if (isEmpty()) {
            return null;
        }
        Node<K, V> minNode = getMinNode(root);
        if (minNode == null) {
            return null;
        }
        return minNode.value;
    }

    /**
     * 获取树中最小节点
     *
     * @param root 要查找的树的根节点
     * @return 最大小所在的节点, 存在返回节点, 不存在返回null
     */
    private Node<K, V> getMinNode(Node<K, V> root) {
        Node<K, V> node = root;
        while (node != null) {
            if (node.left == null) {
                return node;
            }
            node = node.left;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        // 1. key 有就更新
        // 2. 如果没找到就保留 parent 方便后面插入
        Node<K, V> node = root;
        Node<K, V> parent = null;
        while (node != null) {
            parent = node;
            int comparedTo = key.compareTo(node.key);
            switch (comparedTo) {
                case -1 -> node = node.left;
                case 0 -> {
                    node.value = value;
                    return;
                }
                case 1 -> node = node.right;
                default -> throw new IllegalStateException("state: " + comparedTo);
            }
        }
        // 如果找到parent为null,说明树是空的
        if (parent == null) {
            root = new Node<>(key, value);
            return;
        }
        // 大于parent插入右节点.小于parent插入右节点
        int comparedTo = key.compareTo(parent.key);
        if (comparedTo < 0) {
            parent.left = new Node<>(key, value);
        } else {
            parent.right = new Node<>(key, value);
        }
    }

    @Override
    public V remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        while (p != null) {
            int comparedTo = key.compareTo(p.key);
            if (comparedTo < 0) {
                parent = p;
                p = p.left;
            } else if (comparedTo > 0) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }

        // 1.删除节点左右孩子都没有,与只有一个左右孩子逻辑一样
        if (p.left == null && p.right != null) {
            // 2.删除节点没有左孩子,将右孩子交给parent
            shift(parent, p, p.right);
        } else if (p.right == null && p.left != null) {
            // 3.删除节点没有右孩子,将左孩子交给parent
            shift(parent, p, p.left);
        } else {
            // 4.左右孩子都有
            // 4.1 找到右子树最小值
            Node<K, V> sub = p;
            // 后继节点的父亲
            Node<K, V> subParent = p;
            while (sub.left != null) {
                subParent = sub;
                sub = sub.left;
            }
            // 如果不是相邻节点,则先sub的关系
            if (subParent != p) {
                shift(subParent, sub, sub.right);
                sub.right = p.right;
            }
            // 后继取代被删除节点
            shift(parent, p, sub);
            sub.left = p.left;
        }
        return p.value;
    }

    /**
     * 删除节点重建节点与父节点的关系
     *
     * @param parent 被删除节点的父节点
     * @param target 被删除节点
     * @param child  被删除节点的子节点
     */
    private void shift(Node<K, V> parent, Node<K, V> target, Node<K, V> child) {
        // 被删除节点是根节点
        if (parent == null) {
            root = child;
            return;
        }
        // 如果被删除节点是父节点的左孩子
        if (target == parent.left) {
            parent.left = child;
            return;
        }
        // 如果被删除节点是父节点的右孩子
        if (target == parent.right) {
            parent.right = child;
        }
    }
}

