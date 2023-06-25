package data.structure;

/**
 * 堆根接口
 *
 * @author mexioex
 * @date 2023-06-25
 */
public interface Heap<E> {
    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    E poll();

    /**
     * 删除指定索引处元素
     *
     * @param index 指定的索引
     * @return 被删除元素
     */
    E poll(int index);

    /**
     * 获取堆顶元素
     *
     * @return 获取堆顶元素
     */
    E peek();

    /**
     * 堆的尾部追加元素
     *
     * @param offered 被添加的元素
     * @return 是否添加成功
     */
    boolean offer(E offered);

    /**
     * 判断是否非空
     *
     * @return 空返回false, 非空返回ture
     */
    boolean isEmpty();

    /**
     * 获取堆大小
     *
     * @return size
     */
    int size();
}
