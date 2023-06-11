package data.structure.queue.priority;

import data.structure.Queue;

import java.util.Iterator;

/**
 * 堆实现优先队列
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class PriorityQueue3<E extends Priority> implements Queue<E>, Iterable<E> {
    /**
     * 元素数组
     */
    private final Priority[] array;
    /**
     * 元素个数
     */
    private int size;

    /**
     * 1.入队新元素,加入数组末尾(索引位置 child)
     * 2.不断比较新加入元素与它父节点(parent)的优先级
     * 如果父节点优先级底,则向下移动,并找到下一个parent
     * 知道父节点优先级更高或 child==0
     *
     * @param offered 待插入的值
     * @return 入队成功返回true 否则返回false
     */
    @Override
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        // 新元素放在数组末尾
        int child = size++;
        // 父节点为 (子节点-1)/2
        int parent = (child - 1) / 2;
        while (child > 0 && offered.priority() > array[parent].priority()) {
            // 父节点变为子节点
            array[child] = array[parent];
            // 子节点索引变为父节点索引
            child = parent;
            // 计算新的父节点
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    /**
     * 1.交换堆顶元素和和尾部元素,让尾部元素出队
     * 2.下潜
     *
     * @return 尾部元素
     */
    @SuppressWarnings("unchecked")
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        Priority e = array[size];
        array[size] = null;
        // 下潜
        down(0);
        return (E) e;
    }

    /**
     * 1.从堆顶开始,让父元素与两个孩子较大者交换
     * 2.直到父元素大于两个孩子,或者没有孩子为止
     *
     * @param parent 父元素索引
     */
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        // 假设父元素优先级最高
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        // 有孩子比父节点大则就交换
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = 0;

            @Override
            public boolean hasNext() {
                return p < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                Priority priority = array[p];
                p++;
                return (E) priority;
            }
        };
    }

    public PriorityQueue3(int capacity) {
        this.array = new Priority[capacity];
        this.size = 0;
    }
}
