package data.structure;

/**
 * 阻塞队列根接口
 * 目前队列存在的问题:
 * 1.很多厂家需要分离生产者,消费者承担,之前的实现没有考虑线程安全问题
 * 2.队列为空,之前的实现里会返回null,如果一定要拿到一个元素呢？只能不断循环尝试
 * 3.队列为满,之前的实现里会返回false,如果一定要插入一个元素呢？只能不断循环尝试
 * 解决方法:
 * 1.用锁保证线程安全
 * 2.用条件变量让 poll 和 offer进入线程等待状态,而不是不断循环尝试,让cpu空转
 *
 * @author mexioex
 * @date 2023-06-10
 */
public interface BlockingQueue<E> {
    /**
     * 向队尾插入元素
     *
     * @param e 待插入的值
     */
    void offer(E e) throws InterruptedException;

    /**
     * 向队尾插入元素
     *
     * @param e       待插入的值
     * @param timeout 超时时间
     * @return 插入成功 true, 插入失败 false
     */
    boolean offer(E e, long timeout) throws InterruptedException;

    /**
     * 从队列头获取值,并删除
     *
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E poll() throws InterruptedException;

    /**
     * 从队列头获取值,并删除
     *
     * @param timeout 超时时间
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E poll(long timeout) throws InterruptedException;

    /**
     * 从列头获取值,不移除
     *
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E peek() throws InterruptedException;

    /**
     * 从队列头获取值,不移除
     *
     * @param timeout 超时时间
     * @return 队列头非空返回队列头的值, 空返回null
     */
    E peek(long timeout) throws InterruptedException;

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