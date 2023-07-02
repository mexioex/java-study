package data.structure.tree;

import data.structure.AbstractTree;

/**
 * 红黑树实现
 *
 * @author mexioex
 * @date 2023-07-01
 */
public class RedBlackTree<K extends Comparable<K>, V> extends AbstractTree<K, V> {
    @Override
    public void put(K key, V value) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        while (p != null) {
            parent = p;
            int comparedTo = key.compareTo(p.key);
            switch (comparedTo) {
                case -1 -> p = p.left;
                case 0 -> {
                    p.value = value;
                    return;
                }
                case 1 -> p = p.right;
            }
        }
        Node<K, V> inserted = new Node<>(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key.compareTo(parent.key) < 0) {
            parent.left = inserted;
            inserted.parent = parent;
        } else if (key.compareTo(parent.key) > 0) {
            parent.right = inserted;
            inserted.parent = parent;
        }
        size++;
    }

    /**
     * 修复颜色
     *
     * @param node 要修复的节点
     */
    private void fixDoubleRed(Node<K, V> node) {
        // 插入节点是根节点
        if (node == root) {
            node.color = Color.BLACK;
            return;
        }
        // 插入节点的父节点是黑色
        if (isBlack(node.parent)) {
            return;
        }
        // 插入节点的父节点是红色,出发红红相邻
        Node<K, V> parent = node.parent;
        // 获取父节点的兄弟节点
        Node<K, V> parentSibling = node.getParentSibling();
        // 获取父节点的父节点
        Node<K, V> grandParent = parent.parent;
        // 如果父节点与其兄弟节点都是红色
        if (isRed(parentSibling)) {
            // 两个节点都需要变成黑色
            parent.color = Color.BLACK;
            parentSibling.color = Color.BLACK;
            // 父节点的父节点变成红色
            grandParent.color = Color.RED;
            // 可能再次触发红红相邻
            fixDoubleRed(grandParent);
            return;
        }
        // 如果父节点的兄弟节点是黑色
        // 父亲为左孩子,插入节点也是左孩子,触发LL不平衡
        if (parent.isLeft() && node.isLeft()) {
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rotateToRight(grandParent);
            return;
        }
        // 父亲为左孩子,插入节点是右孩子,触发R不平衡
        if (parent.isLeft() && !node.isLeft()) {
            rotateToLeft(parent);
            node.color = Color.BLACK;
            grandParent.color = Color.RED;
            rotateToRight(grandParent);
            return;
        }
        // 父亲为右孩子,插入节点也是右孩子,触发RR不平衡
        if (!parent.isLeft() && !node.isLeft()) {
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rotateToLeft(grandParent);
            return;
        }
        // 父亲为右孩子,插入节点是左孩子,触发RL不平衡
        if (!parent.isLeft() && node.isLeft()) {
            rotateToRight(parent);
            node.color = Color.BLACK;
            grandParent.color = Color.RED;
            rotateToLeft(grandParent);
        }
    }

    @Override
    public V remove(K key) {
        Node<K, V> deleted = getNode(key);
        if (deleted == null) {
            return null;
        }
        doRemove(deleted);
        size--;
        return deleted.value;
    }

    private void doRemove(Node<K, V> deleted) {
        // 找到要替换上去的节点
        Node<K, V> replaced = findReplaced(deleted);
        // 获取删除节点的父节点
        Node<K, V> parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            // 如果删除的是根节点
            if (deleted == root) {
                root = null;
            } else {
                // 删除节点是黑色,红节点不做任何处理
                if (isBlack(deleted)) {
                    fixDoubleBlack(deleted);
                }
                if (deleted.isLeft()) {
                    // 删除左孩子
                    parent.left = null;
                } else {
                    // 删除右孩子
                    parent.right = null;
                }
                // 断掉链接.帮助gc
                deleted.parent = null;
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            // 如果删除的是根节点
            if (deleted == root) {
                // 替换根节点的 key, value
                root.key = replaced.key;
                root.value = replaced.value;
                // 清空根节点的孩子
                root.left = null;
                root.right = null;
            } else {
                if (deleted.isLeft()) {
                    // 删除左孩子,用后继替换原来的左孩子
                    parent.left = replaced;
                } else {
                    // 删除右孩子,用后继替换原来的右孩子
                    parent.right = replaced;
                }
                // 替换新孩子的父亲
                replaced.parent = parent;
                // 断掉原来节点的链接
                deleted.left = deleted.right = deleted.parent = null;
                // 如果删除的节点和升上来的节点都是黑色
                if (isBlack(deleted) && isBlack(replaced)) {
                    fixDoubleBlack(replaced);
                } else {
                    // 升上来的节点是红色
                    replaced.color = Color.BLACK;
                }
            }
            return;
        }

        // 有两个孩子
        // 让替换的节点的 key 和 value,与删除的节点 key 和 value 互换
        K deletedKey = deleted.key;
        deleted.key = replaced.key;
        replaced.key = deletedKey;
        V deletedValue = deleted.value;
        deleted.value = replaced.value;
        replaced.value = deletedValue;
        // 删除替换节点
        doRemove(replaced);
    }

    /**
     * 修复双黑，双黑指少了一个黑色元素
     *
     * @param node 被调整节点
     */
    private void fixDoubleBlack(Node<K, V> node) {
        if (node == root) {
            return;
        }
        Node<K, V> parent = node.parent;
        Node<K, V> sibling = node.getSibling();
        // 被调整兄弟节点是红色个
        if (isRed(sibling)) {
            // 被调整节点是左孩子,父亲右旋,是右孩子,父亲左旋
            if (node.isLeft()) {
                rotateToLeft(parent);
            } else {
                rotateToRight(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(node);
            return;
        }
        if (sibling != null) {
            // 兄弟是黑色,并且侄子也是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                if (isRed(parent)) {
                    parent.color = Color.BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            } else {
                // 兄弟是黑色,侄子有红色,进入这里
                // 如果兄弟是左孩子,左侄子是红色,触发 LL 旋转
                if (sibling.isLeft() && isRed(sibling.left)) {
                    rotateToRight(parent);
                    sibling.left.color = Color.BLACK;
                    sibling.color = parent.color;
                    parent.color = Color.BLACK;
                }
                // 如果兄弟是左孩子,右侄子是红色,触发 LR 旋转
                if (sibling.isLeft() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    rotateToLeft(sibling);
                    rotateToRight(parent);
                    parent.color = Color.BLACK;
                }
                // 如果兄弟是右孩子,右侄子是红色,触发 RR 旋转
                if (!sibling.isLeft() && isRed(sibling.right)) {
                    rotateToLeft(parent);
                    sibling.right.color = Color.BLACK;
                    sibling.color = parent.color;
                    parent.color = Color.BLACK;
                }
                // 如果兄弟是右孩子,左侄子是红色,触发 RL 旋转
                if (!sibling.isLeft() && isRed(sibling.left)) {
                    sibling.left.color = parent.color;
                    rotateToRight(sibling);
                    rotateToLeft(parent);
                    parent.color = Color.BLACK;
                }
            }
        } else {
            fixDoubleBlack(parent);
        }
    }

    /**
     * 找到当前被删除后.需要替换当前位置的节点
     *
     * @param node 当前节点
     * @return 当前节点没有孩子返回null, 左边不存在返回右边, 右边不存在返回左边, 两个都存在返回直接后继
     */
    private Node<K, V> findReplaced(Node<K, V> node) {
        // 左右子节点都不存在返回null
        if (node.left == null && node.right == null) {
            return null;
        }
        // 左子节点都不存在返回右子节点
        if (node.left == null) {
            return node.right;
        }
        // 右子节点都不存在返回左子节点
        if (node.right == null) {
            return node.left;
        }
        // 左右子节点都存在,就找到直接后继
        Node<K, V> s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }

    /**
     * 右旋
     * 1.获取参数节点的左孩子
     * 2.获取参数节点的左孩子的右孩子
     * 3.修改第二步节点的父节点为参数节点
     * 4.参数节点变成其左孩子的右孩子
     * 5.修改旋转后的根节点的父节点为参数节点的父节点
     * 6.参数节点的右孩子,变成其左孩子的右孩子
     *
     * @param node 需要右旋的节点
     */
    private void rotateToRight(Node<K, V> node) {
        // 记录原来的父节点
        Node<K, V> parent = node.parent;
        // 获取参数节点的左孩子,作为新的根节点
        Node<K, V> left = node.left;
        // 获取参数节点的左孩子的右孩子
        Node<K, V> right = left.right;
        // 修改父节点
        if (right != null) {
            right.parent = node;
        }
        // 参数节点变成其左孩子的右孩子
        left.right = node;
        // 修改旋转后的根节点的父节点为参数节点的父节点
        left.parent = node.parent;
        // 参数节点的左孩子,变成其左孩子的右孩子
        node.left = right;
        // 参数节点的父节点变成新的根节点
        node.parent = left;
        // 如果父节点为空,新节点作为根节点
        if (parent == null) {
            root = left;
        } else if (parent.left == node) {
            // 如果参数节点是父节点的左孩子,父节点左孩子变成新节点
            parent.left = left;
        } else {
            // 如果参数节点是父节点的右孩子,父节点右孩子变成新节点
            parent.right = left;
        }
    }

    /**
     * 左旋
     * 1.获取参数节点的右孩子
     * 2.获取参数节点的右孩子的左孩子
     * 3.修改第二步节点的父节点为参数节点
     * 4.参数节点变成其右孩子的左孩子
     * 5.修改旋转后的根节点的父节点为参数节点的父节点
     * 6.参数节点的左孩子,变成其右孩子的左孩子
     *
     * @param node 需要左旋的节点
     */
    private void rotateToLeft(Node<K, V> node) {
        // 记录原来的父节点
        Node<K, V> parent = node.parent;
        // 获取参数节点的右孩子,作为新的根节点
        Node<K, V> right = node.right;
        // 获取参数节点的右孩子的左孩子
        Node<K, V> left = right.left;
        // 修改父节点
        if (left != null) {
            left.parent = node;
        }
        // 参数节点变成其右孩子的左孩子
        right.left = node;
        // 修改旋转后的根节点的父节点为参数节点的父节点
        right.parent = node.parent;
        // 参数节点的右孩子,变成其右孩子的左孩子
        node.right = left;
        // 参数节点的父节点变成新的根节点
        node.parent = right;
        // 如果父节点为空,新节点作为根节点
        if (parent == null) {
            root = right;
        } else if (parent.right == node) {
            // 如果参数节点是父节点的右孩子,父节点右孩子变成新节点
            parent.right = right;
        } else {
            // 如果参数节点是父节点的左孩子,父节点左孩子变成新节点
            parent.left = right;
        }
    }
}
