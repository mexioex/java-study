package data.structure;

import java.util.NoSuchElementException;

/**
 * 抽象堆接口所有的堆实现应该实现此接口
 *
 * @author mexioex
 * @date 2023-06-25
 */
public abstract class AbstractHeap<E extends Comparable<E>> implements Heap<E> {
    /**
     * 存储节点
     */
    protected final E[] array;

    /**
     * 堆长度
     */
    protected int size;

    /**
     * 建堆
     * 1.找到最后一个非叶子节点
     * 2.从后向前堆每个节点执行下潜
     */
    private void heaping() {
        // size / 2 -1 就是最后一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 将parent 索引处的元素元素下潜: 与两个孩子较大者交换,直至没有孩子或者孩子没它大
     *
     * @param parent 父节点索引
     */
    private void down(int parent) {
        // 左孩子
        int left = parent * 2 + 1;
        // 右孩子
        int right = left + 1;
        // 默认当前节点为最大
        int max = parent;
        if (isNeedAdjust(left, parent)) {
            max = left;
        }
        if (isNeedAdjust(right, parent)) {
            max = right;
        }
        // 找到了更大的孩子
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    /**
     * 交换
     *
     * @param i 索引1
     * @param j 索引2
     */
    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // 堆顶元素
        E top = array[0];
        // 交换堆顶元素去最后
        swap(0, size - 1);
        // 长度-1
        size--;
        // 交换上来的元素下沉
        down(0);
        return top;
    }

    @Override
    public E poll(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index > size) {
            throw new NoSuchElementException(String.valueOf(index));
        }
        // 堆顶元素
        E polled = array[index];
        // 交换堆顶元素去最后
        swap(index, size - 1);
        // 长度-1
        size--;
        // 交换上来的元素下沉
        down(index);
        return polled;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }

    @Override
    public boolean offer(E offered) {
        if (size == array.length) {
            return false;
        }
        array[size++] = offered;
        up(offered);
        return true;
    }

    /**
     * 将 offered 元素上浮,直至offered 小于父元素或者到堆顶
     *
     * @param offered 上浮的索引
     */
    private void up(E offered) {
        // 新添加的元素在最后一位
        int child = size;
        while (child > 0) {
            // 获取父元素索引
            int parent = (child - 1) / 2;
            if (offered.compareTo(array[parent]) > 0) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 是否需要重新调整堆
     *
     * @param child  父或者子节点索引
     * @param parent 父索引
     * @return 需要返回true, 不需要返回false
     */
    protected abstract boolean isNeedAdjust(int child, int parent);

    @SuppressWarnings("all")
    public AbstractHeap(int capacity) {
        this.array = (E[]) new Comparable[capacity];
    }
}
