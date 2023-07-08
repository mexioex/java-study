package data.structure.heap;

import org.junit.Assert;
import org.junit.Test;

/**
 * 大顶堆测试
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class MaxHeapTest {
    @Test
    public void test() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        Assert.assertTrue(maxHeap.isEmpty());
        maxHeap.offer(7);
        maxHeap.offer(6);
        maxHeap.offer(5);
        maxHeap.offer(4);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(1);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }
}
