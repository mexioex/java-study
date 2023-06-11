package data.structure;

/**
 * 队列根接口
 *
 * @author mexioex
 * @date 2023-06-10
 */
public interface Queue<E> {
    /**
     * 向队尾插入元素
     *
     * @param value 待插入的值
     * @return 插入成功 true, 插入失败 false
     */
    boolean offer(E value);

    /**
     * 从队列头获取值,并删除
     *
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E poll();

    /**
     * 从列头获取值,不移除
     *
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E peek();

    /**
     * 检查队列是否为空
     *
     * @return 空返回true, 非空返回false
     */
    boolean isEmpty();

    /**
     * 判断队列是否已满
     *
     * @return 满返回true, 未满返回false
     */
    boolean isFull();
}
