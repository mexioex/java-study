package data.structure.tree;

import data.structure.AbstractTree;

/**
 * 平衡二叉树实现
 *
 * @author mexioex
 * @date 2023-07-01
 */
public class AVLTree<K extends Comparable<K>, V> extends AbstractTree<K, V> {
    @Override
    public void put(K key, V value) {
        root = doPut(root, key, value);
    }

    /**
     * 放置值
     *
     * @param node  开始的节点
     * @param key   节点的keu
     * @param value 节点的value
     * @return key所在的节点
     */
    private Node<K, V> doPut(Node<K, V> node, K key, V value) {
        // 1. 找到空位,创建新节点
        if (node == null) {
            return new Node<>(key, value);
        }
        // 2. key已存在,更新
        if (key.equals(node.key)) {
            node.value = value;
            return node;
        }
        // 3. 继续查找
        int comparedTo = key.compareTo(node.key);
        if (comparedTo < 0) {
            node.left = doPut(node.left, key, value);
        } else if (comparedTo > 0) {
            node.right = doPut(node.right, key, value);
        }
        // 更新高度
        setHeight(node);
        // 平衡
        return balance(node);
    }

    @Override
    public V remove(K key) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }
        root = doRemove(root, key);
        return node.value;
    }

    private Node<K, V> doRemove(Node<K, V> node, K key) {
        // 1. node == null
        if (node == null) {
            return null;
        }
        // 2. 没找到key
        int comparedTo = key.compareTo(node.key);
        if (comparedTo < 0) {
            // 2.1. 向左找
            node.left = doRemove(node.left, key);
        } else if (comparedTo > 0) {
            // 2.1. 向右找
            node.right = doRemove(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                // 没有左右孩子,删了就不剩
                return null;
            } else if (node.left == null) {
                // 剩下右孩子
                node = node.right;
            } else if (node.right == null) {
                // 剩下右孩子
                node = node.left;
            } else {
                // 找到后继节点
                Node<K, V> s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                // 删除后继节点的右子树
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                node = s;
            }
        }
        // 4. 更新高度
        setHeight(node);
        // 5.检查失衡
        return balance(node);
    }

    /**
     * 如果 node 节点没有右孩子
     * 向右边旋转,原来的左孩子变成新的根节点,原来的根节点变成新的根节点的右孩子
     * 如果 node 节点有右孩子
     * node 的右孩子变成新节点右孩子的左孩子
     *
     * @param node 要旋转的节点
     * @return 新的根节点
     */
    private Node<K, V> rotateToRight(Node<K, V> node) {
        // 被右旋上去需要变成新的根节点的节点
        Node<K, V> newNode = node.left;
        // 被右旋上去节点的右孩子，需要变成被右旋上去的节点的右孩子的左孩子
        Node<K, V> rightChild = newNode.right;
        // 原节点变成新节点的右孩子
        newNode.right = node;
        // 原节点的左孩子变成新节点的右孩子
        node.left = rightChild;
        // 新节点高度
        setHeight(newNode);
        // 更新原节点高度
        setHeight(node);
        return newNode;
    }

    /**
     * 如果 node 节点没有左孩子
     * 向左边旋转,原来的右孩子变成新的根节点,原来的根节点变成新的根节点的左孩子
     * 如果 node 节点有左孩子
     * node 的左孩子变成新节点左孩子的右孩子
     *
     * @param node 要旋转的节点
     * @return 新的根节点
     */
    private Node<K, V> rotateToLeft(Node<K, V> node) {
        // 被左旋上去需要变成新的根节点的节点
        Node<K, V> newNode = node.right;
        // 被左旋上去节点的左孩子，需要变成被左旋上去的节点的左孩子的右孩子
        Node<K, V> leftChild = newNode.left;
        // 原节点变成新节点的左孩子
        newNode.left = node;
        // 原节点的右孩子变成新节点的左孩子
        node.right = leftChild;
        // 新节点高度
        setHeight(newNode);
        // 更新原节点高度
        setHeight(node);
        return newNode;
    }

    /**
     * 先旋转左子树,再旋转根节点
     *
     * @return 新的根节点
     */
    private Node<K, V> lrRotate(Node<K, V> node) {
        node.left = rotateToLeft(node.left);
        return rotateToRight(node);
    }

    /**
     * 先旋转右子树,再旋转根节点
     *
     * @return 新的根节点
     */
    private Node<K, V> rlRotate(Node<K, V> node) {
        node.right = rotateToRight(node.right);
        return rotateToLeft(node);
    }

    /**
     * 检查节点是否失衡
     *
     * @param node 需要检查的节点
     * @return 如果节点已失衡就完成平衡返回新的节点
     */
    private Node<K, V> balance(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        int balanceFactor = geBalanceFactor(node);
        if (balanceFactor > 1 && geBalanceFactor(node.left) > 0) {
            // LL,失衡节点是左子树的左子树,向右旋转
            return rotateToRight(node);
        } else if (balanceFactor > 1 && geBalanceFactor(node.right) < 0) {
            // LR,失衡节点是左子树的右子树,先左后右旋转
            return lrRotate(node);
        } else if (balanceFactor < -1 && geBalanceFactor(node.right) > 0) {
            // RL,失衡节点是右子树的左子树,先右后左
            return rlRotate(node);
        } else if (balanceFactor < -1 && geBalanceFactor(node.right) < 0) {
            // RR,失衡节点是右子树的右子树,向左旋转
            return rotateToLeft(node);
        }
        return node;
    }
}