package data.structure.array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 动态数组实现
 *
 * @author mexioex
 * @date 2023-06-07
 */
public class DynamicArray implements Iterable<Integer> {
    /**
     * 逻辑大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    private int[] array = {};

    /**
     * 添加元素到数组最后一位
     *
     * @param element 目标元素
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 添加元素到指定索引的后面
     *
     * @param index   索引
     * @param element 元素
     */
    public void add(int index, int element) {
        checkAndGrow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 判断数组容量是否足够,不够就进行扩容
     */
    private void checkAndGrow() {
        // 懒加载,真正添加时才扩容
        if (size == 0) {
            array = new int[capacity];
        }
        // 容量检查,没有位置了就扩容
        else if (size == capacity) {
            // 扩容 1.5 倍
            capacity += capacity + capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 删除数组第一个元素
     *
     * @return 被删除元素
     */
    public int remove() {
        return remove(0);
    }

    /**
     * 删除数组 index 位的元素
     *
     * @param index 目标索引
     * @return 被删除元素
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 修改数组指定索引的元素
     *
     * @param index   要修改的索引
     * @param element 新的元素
     */
    public void set(int index, int element) {
        if (index <= size - 1) {
            array[index] = element;
        }
    }

    /**
     * 获取指定索引处的元素
     *
     * @param index 要查询的索引
     * @return 索引处的值
     */
    public int get(int index) {
        if (index <= size - 1) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * 获取动态数组长度
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * 判断动态数组是否为空
     *
     * @return size == 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public DynamicArray() {
        this.size = 0;
        this.capacity = 8;
    }

    public DynamicArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (int i = 0; i < size; i++) {
            action.accept(array[i]);
        }
    }
}