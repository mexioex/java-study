package design.pattern.behavioral.iterator;

/**
 * 抽象容器
 *
 * @author mexioex
 * @date 2023-06-30
 */
public interface Aggregate<E> {
    /**
     * 创建容器
     *
     * @return Iterator
     */
    Iterator<E> createIterator();
}
