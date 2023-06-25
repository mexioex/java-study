package data.structure.heap;

import data.structure.AbstractHeap;

/**
 * 小顶堆实现
 *
 * @author mexioex
 * @date 2023-06-25
 */
public class MinHeap<E extends Comparable<E>> extends AbstractHeap<E> {
    public MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    protected boolean isNeedAdjust(int child, int parent) {
        return child < size && array[child].compareTo(array[parent]) < 0;
    }
}