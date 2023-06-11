package data.structure;

/**
 * 双端队列
 *
 * @author mexioex
 * @date 2023-06-10
 */
public interface Deque<E> {
    /**
     * 向队首插入元素
     *
     * @param value 待插入的值
     * @return 插入成功 true, 插入失败 false
     */
    boolean offerFirst(E value);

    /**
     * 向队尾插入元素
     *
     * @param value 待插入的值
     * @return 插入成功 true, 插入失败 false
     */
    boolean offerLast(E value);

    /**
     * 从队头获取值,并删除
     *
     * @return 队列头非空返回队头的值, 空返回null
     */
    E pollFirst();

    /**
     * 从队尾获取值,并删除
     *
     * @return 队列尾非空返回队头的值, 空返回null
     */
    E pollLast();

    /**
     * 从列头获取值,不移除
     *
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E peekFirst();

    /**
     * 从列尾获取值,不移除
     *
     * @return 队列尾非空返回队列尾的值, 空返回null
     */
    E peekLast();

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
