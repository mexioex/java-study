package data.structure.tree;

import data.structure.Tree;

import java.util.Arrays;

/**
 * B+树实现
 *
 * @author mexioex
 * @date 2023-07-02
 */
public class BPlusTree<K extends Comparable<K>, V> implements Tree<K, V> {
    /**
     * 树的最小度
     */
    private final int degree;

    /**
     * 根节点
     */
    private Node<K, V> root;

    /**
     * 最小孩子数量 degree -1
     */
    final int MIN_KEY_NUM;

    /**
     * 最大孩子数量 2 * degree -1
     */
    final int MAX_KEY_NUM;

    /**
     * 哨兵节点
     */
    private final LeafNode<K, V> sentinel;

    /**
     * 判断 key 是否存在
     *
     * @param key 要判断的key
     * @return 存在返回true, 否则返回false
     */
    public boolean contains(K key) {
        return root.get(key) != null;
    }

    @Override
    public void put(K key, V value) {
        doPut(root, key, null, 0, value);
    }

    /**
     * 1.遍历 keys
     * 2.有效 key 的索引小于 keyNum
     * 3.如果 key 相等 就更新
     * 4.如果 key 大于 keys 中所有的节点的 key,意味着 key 对应的节点不存在
     * 5.如果 key 小于 keys 中的第 i 个节点,则表示此 key 在 keys[i]的 keys中
     *
     * @param node 插入的节点
     * @param key  插入的key
     */
    private void doPut(Node<K, V> node, K key, Node<K, V> parent, int index, V value) {
        int i = 0;
        while (i < node.keyNum) {
            int comparedTo = node.keys[i].compareTo(key);
            // 更新
            if (comparedTo == 0) {
                // 如果是叶子节点直接更新.叶子节点的 value.不相等就去它的孩子中
                return;
            }
            if (comparedTo > 0) {
                // 找到了插入位置,此时的 i 就是插入节点
                break;
            }
            i++;
        }
        // 如果是叶子节点
        if (node.leaf) {
            LeafNode<K, V> kvLeafNode = new LeafNode<>(null, null, key, value);
            node.put(key, i);
            node.leafNode = kvLeafNode;
            // 如果parent是null,没有上级节点了
            if (i == 0) {
                if (parent == null) {
                    kvLeafNode.prev = sentinel;
                    sentinel.next = kvLeafNode;
                }
                if (parent != null) {
                    Node<K, V>[] children = parent.children;
                    int parentSiblingIndex = 0;
                    while (parentSiblingIndex < children.length) {
                        if (children[parentSiblingIndex] == node) {
                            break;
                        }
                        parentSiblingIndex++;
                    }
                    LeafNode<K, V> leafNode = children[parentSiblingIndex].leafNode;
                    while (leafNode != null) {
                        if (leafNode.key.compareTo(key) > 0) {
                            break;
                        }
                        leafNode = leafNode.next;
                    }
                    kvLeafNode.prev = leafNode;
                    LeafNode<K, V> next = leafNode.next;
                    kvLeafNode.next = next;
                    next.prev = kvLeafNode;
                }
            } else {
                // 从哨兵节点找到 第一个大于 key 的节点前面插入
                Node<K, V> leftSibling = node.leftSibling(index);
                assert leftSibling != null;
                LeafNode<K, V> start = leftSibling.leafNode;
                while (start != null) {
                    if (start.key.compareTo(key) > 0) {
                        break;
                    }
                    start = start.next;
                }
                if (start != null) {
                    // 找到了
                    kvLeafNode.prev = start;
                    LeafNode<K, V> next = start.next;
                    kvLeafNode.next = next;
                    next.prev = kvLeafNode;
                } else {
                    // 没找到
                    kvLeafNode.prev = sentinel;
                    sentinel.next = kvLeafNode;
                }
            }
        } else {
            // 如果不是非叶子节点，需要在 children[i] 出开始进行递归插入
            doPut(node.children[i], key, node, i, value);
        }
        // 插入完毕节点需要进行分裂
        if (node.keyNum == MAX_KEY_NUM) {
            split(node, parent, index);
        }
    }

    /**
     * 节点分裂
     * 1.如果分裂的是根节点则新建一个节点作为新的根节点,原来的节点作为新根节点的第一个child
     * 2.如果是叶子节点,则新建一个节点,将要分裂节点的度往后的 key ,复制到新节点的 keys 中
     * 3.如果不是叶子节点,则需要将要分裂节点的度往后的 child, 复制到上一步创建的新节点的 children 中
     * 4.重置被分裂节点和承载分裂元素的节点的有效 key 个数
     * 5.将被分裂节点 degree+1 处的 key 插入到父节点
     * 6.将承载分裂节点元素的新节点,插入到父节点 index+1 处
     *
     * @param left   被分裂节点
     * @param parent 父节点
     * @param index  被分裂节点在父节点中的索引
     */
    private void split(Node<K, V> left, Node<K, V> parent, int index) {
        // 如果是根节点,新建节点替换原来的节点,再进行分裂
        if (parent == null) {
            Node<K, V> newRoot = new Node<>(degree);
            newRoot.leaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }
        // 创建 right 节点(分裂后大于当前left节点的), 把 degree 以后的key 和 child 拷贝过去
        Node<K, V> right = new Node<>(degree);
        // right 跟 leaf 保持一样的叶子节点属性
        right.leaf = left.leaf;
        // 将 left 的中 degree-1 后面的 key 拷贝到 right 中
        System.arraycopy(left.keys, degree, right.keys, 0, degree - 1);
        // 如果不是叶子节点,需要将孩子节点拷贝过去
        if (!left.leaf) {
            // 将 left 的中 degree-1 后面的 child 拷贝到 right 中
            System.arraycopy(left.children, degree, right.children, 0, degree - 1);
        }
        // right 中有效的 key 应该是 degree - 1
        right.keyNum = degree - 1;
        left.keyNum = degree - 1;
        // 2.degree -1 处的 key 插入到 parent 的 index 处, index 指 left 作为孩子时的索引
        K key = left.keys[degree - 1];
        parent.put(key, index);
        // 3. right 节点作为 parent 的孩子插入到 index +1 处
        parent.insertChild(right, index + 1);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return -1;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        V v = get(key);
        doRemove(null, root, key, 0);
        return v;
    }

    /**
     * 删除树中 key 对应的节点
     *
     * @param parent 被删除的节点父亲
     * @param node   树
     * @param key    要删除的 key
     * @param index  被删除节点的索引
     */
    private void doRemove(Node<K, V> parent, Node<K, V> node, K key, int index) {
        // 找到要删除的 key 的索引
        int i = 0;
        while (i < node.keyNum) {
            int comparedTo = node.keys[i].compareTo(key);
            if (comparedTo >= 0) {
                break;
            }
            i++;
        }
        /*
        找到 i, i 代表要删除的 key 的索引
        没找到 i, i 代表到第 i 个孩子中继续查找
         */
        // 当前节点是否是叶子节点
        if (node.leaf) {
            if (isNotFound(node, key, i)) {
                // 是叶子节点,但是没找到
                return;
            } else {
                // 是叶子节点,找到了
                node.removeKey(i);
            }
        } else {
            if (isNotFound(node, key, i)) {
                // 不是叶子节点,但是没找到
                doRemove(node, node.children[i], key, index);
            } else {
                // 不是叶子节点,找到了
                // 1. 找到后继 key
                Node<K, V> s = node.children[i + 1];
                while (!s.leaf) {
                    s = s.children[0];
                }
                K sKey = s.keys[0];
                // 2. 替换待删除 key 和 value
                node.keys[i] = sKey;
                // 3. 删除后继 key
                doRemove(node, node.children[i + 1], sKey, i + 1);
            }
        }
        // 判断树中 key 的个数是否小于下限,如果是,就需要重新平衡
        if (node.keyNum < MIN_KEY_NUM) {
            balance(parent, node, index);
        }
    }

    /**
     * 重新平衡
     *
     * @param node   要平衡的节点
     * @param parent 要平衡节点的父节点
     * @param index  要平衡节点的索引
     */
    private void balance(Node<K, V> node, Node<K, V> parent, int index) {
        // 被调整节点是根节点
        if (node == root) {
            if (root.keyNum == 0 && root.children != null) {
                root.children[0].leafNode = null;
                root = root.children[0];
            }
            return;
        }
        // 获取节点的左右兄弟节点
        Node<K, V> leftSibling = parent.leftSibling(index);
        Node<K, V> rightSibling = parent.rightSibling(index);
        // 左边兄弟不为空,且兄弟的 keys 比最小 key 数量多
        if (leftSibling != null && leftSibling.keyNum > MIN_KEY_NUM) {
            // 把父节点的 key 和 value 移动到子节点
            K key = parent.keys[index - 1];
            node.put(key, 0);
            // 如果左孩子不是叶子节点
            if (!leftSibling.leaf) {
                node.insertChild(leftSibling.removeMostRightNode(), 0);
            }
            // 父节点被旋转下去的 key 替换为左孩子中最右边的 key
            parent.keys[index - 1] = leftSibling.removeMostRightKey();
            return;
        }
        // 右边兄弟不为空,且兄弟的 keys 比最小 key 数量多
        if (rightSibling != null && rightSibling.keyNum > MIN_KEY_NUM) {
            // 把父节点的 key 和 value 移动到子节点
            K key = parent.keys[index];
            node.put(key, node.keyNum);
            // 如果右孩子不是叶子节点
            if (!rightSibling.leaf) {
                node.insertChild(rightSibling.removeMostLeftNode(), node.keyNum + 1);
            }
            // 父节点被旋转下去的 key 替换为右孩子孩子中最左边的 key
            parent.keys[index] = rightSibling.removeMostLeftKey();
            return;
        }
        // 两边都不够,合并到左边
        if (leftSibling != null) {
            // 向左合并
            parent.removeNode(index);
            K k = parent.removeKey(index - 1);
            leftSibling.put(k, leftSibling.keyNum);
            node.moveToTarget(leftSibling);
        } else {
            // 向自己合并
            parent.removeNode(index + 1);
            K k = parent.removeKey(index);
            node.put(k, node.keyNum);
            assert rightSibling != null;
            rightSibling.moveToTarget(node);
        }
    }

    /**
     * 是否找到要删除key对应的索引
     *
     * @param node  key 所在的节点
     * @param key   目标 key
     * @param index key 在 node children 中的索引
     * @return 找到返回 true,没找到返回 false
     */
    private boolean isNotFound(Node<K, V> node, K key, int index) {
        return index >= node.keyNum || node.keys[index].compareTo(key) != 0;
    }

    public BPlusTree() {
        this(2);
    }

    public BPlusTree(int degree) {
        this.degree = degree;
        this.root = new Node<>(degree);
        MIN_KEY_NUM = degree - 1;
        MAX_KEY_NUM = 2 * degree - 1;
        this.sentinel = new LeafNode<>(null, null, null, null);
    }

    /**
     * 索引节点类
     *
     * @param <K> 关键字
     * @param <V> 值
     */
    private static class Node<K extends Comparable<K>, V> {
        /**
         * 关键字
         */
        K[] keys;
        /**
         * 孩子
         */
        Node<K, V>[] children;
        /**
         * 有效关键字数目
         */
        int keyNum;
        /**
         * 是否叶子节点
         */
        boolean leaf = true;
        /**
         * 最小度树
         */
        int degree;
        /**
         * 聊表中的数据节点
         */
        LeafNode<K, V> leafNode;

        /**
         * 1.遍历 keys
         * 2.有效 key 的索引小于 keyNum
         * 3.如果 key 相等 直接返回当前节点
         * 4.如果 key 大于 keys 中所有的节点的 key,意味着 key 对应的节点不存在
         * 5.如果 key 小于 keys 中的第 i 个节点,则表示此 key 在 keys[i]的 keys中
         *
         * @param key 要查找的 key 对应的节点
         * @return 节点存在返回节点, 不存在返回 null
         */
        Node<K, V> get(K key) {
            int i = 0;
            while (i < keyNum) {
                int comparedTo = keys[i].compareTo(key);
                if (comparedTo == 0) {
                    return this;
                }
                if (comparedTo > 0) {
                    break;
                }
                i++;
            }
            // 执行到此时 keys[i] > key 或 i == keyNum
            // 判断是否是叶子节点
            if (leaf) {
                return null;
            }
            // 非叶子情况
            return children[i].get(key);
        }

        /**
         * 向指定 keys 中插入一个 key
         *
         * @param key   被插入 key
         * @param index 插入位置
         */
        void put(K key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNum - index);
            keys[index] = key;
            keyNum++;
        }

        /**
         * 向当前节点指定索引处插入一个孩子节点
         *
         * @param child 插入的孩子
         * @param index 插入的位置
         */
        void insertChild(Node<K, V> child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNum - index);
            children[index] = child;
            keyNum++;
        }

        /**
         * 通过 index 删除 key
         *
         * @param index key 在 keys 中的索引
         * @return 被删除key
         */
        K removeKey(int index) {
            K key = keys[index];
            System.arraycopy(keys, index + 1, keys, index, keyNum - 1 - index);
            keyNum--;
            return key;
        }

        /**
         * 删除 keys 最左边的 key
         *
         * @return 被删除的 key
         */
        K removeMostLeftKey() {
            return removeKey(0);
        }

        /**
         * 删除 keys 最左边的 key
         *
         * @return 被删除的 key
         */
        K removeMostRightKey() {
            return removeKey(keyNum - 1);
        }

        /**
         * 删除 children 的索引处的孩子
         *
         * @param index child 在 children 的索引
         * @return 被删除节点
         */
        Node<K, V> removeNode(int index) {
            Node<K, V> child = children[index];
            System.arraycopy(children, index + 1, children, index, keyNum - index);
            return child;
        }

        /**
         * 删除 children 最左边的节点
         *
         * @return 被删除节点
         */
        Node<K, V> removeMostLeftNode() {
            return removeNode(0);
        }

        /**
         * 删除 children 最右边的节点
         *
         * @return 被删除节点
         */
        Node<K, V> removeMostRightNode() {
            return removeNode(keyNum);
        }

        /**
         * 获取 index 孩子左边的兄弟
         *
         * @param index 节点在 children 中的索引
         * @return 被删除节点
         */
        Node<K, V> leftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        /**
         * 获取 index 孩子右边的兄弟
         *
         * @param index 节点在 children 中的索引
         * @return 被删除节点
         */
        Node<K, V> rightSibling(int index) {
            return index == keyNum ? null : children[index + 1];
        }

        /**
         * 赋值当前节点的所有 key,value,child 到 target
         *
         * @param target 存放赋值元素的节点
         */
        void moveToTarget(Node<K, V> target) {
            if (!leaf) {
                int start = target.keyNum;
                for (int i = 0; i <= keyNum; i++) {
                    target.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNum; i++) {
                target.keys[target.keyNum] = keys[i];
                target.keyNum++;
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNum));
        }

        @SuppressWarnings("all")
        public Node(int degree) {
            this.degree = degree;
            // 最多孩子数等于最小度*2
            this.children = (Node<K, V>[]) new Node<?, ?>[2 * degree];
            // 关键字数比孩子少1
            this.keys = (K[]) new Comparable[2 * degree - 1];
        }
    }

    /**
     * 叶子节点
     *
     * @param <K> 叶子节点的 key
     * @param <V> 叶子节点的 value
     */
    private static class LeafNode<K, V> {
        /**
         * 前一个节点
         */
        LeafNode<K, V> prev;

        /**
         * 后一个节点
         */
        LeafNode<K, V> next;

        /**
         * 节点 key
         */
        K key;

        /**
         * 节点value
         */
        V value;

        public LeafNode(LeafNode<K, V> prev, LeafNode<K, V> next, K key, V value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
}
