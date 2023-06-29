package data.structure;

/**
 * 树的根接口
 *
 * @author mexioex
 * @date 2023-06-26
 */
public interface Tree<K extends Comparable<K>, V> {
    /**
     * 判断树是否非空
     *
     * @return 空返回true, 非空返回false
     */
    boolean isEmpty();

    /**
     * 获取书中元素个数
     *
     * @return size
     */
    int size();

    /**
     * 获取树中 key 对应的元素
     *
     * @param key 节点的 key
     * @return 节点的value
     */
    V get(K key);

    /**
     * 向树中添加元素
     *
     * @param key   节点的key
     * @param value 节点的value
     */
    void put(K key, V value);

    /**
     * 从树中移除指定元素的key
     *
     * @param key 指定的key
     * @return key节点对应的value
     */
    V remove(K key);
}
