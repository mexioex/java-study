package design.pattern.behavioral.iterator;

/**
 * 抽象迭代器
 *
 * @author mexioex
 * @date 2023-06-30
 */
public interface Iterator<E> {
    /**
     * 获取下一个
     *
     * @return 下一个元素
     */
    E next();

    /**
     * 判断是否有下一个元素
     *
     * @return 有为true没有就false
     */
    boolean hasNext();
}
