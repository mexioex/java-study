package data.structure.heap;

import data.structure.AbstractHeap;

/**
 * 大顶堆实现
 *
 * @author mexioex
 * @date 2023-06-25
 */
public class MaxHeap<E extends Comparable<E>> extends AbstractHeap<E> {
    public MaxHeap(int capacity) {
        super(capacity);
    }

    @Override
    protected boolean isNeedAdjust(int child, int parent) {
        return child < size && array[child].compareTo(array[parent]) > 0;
    }
}
