package data.structure.queue.single;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

/**
 * 队列测试
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayQueue1Test {
    @Test
    public void testOffer() {
        CircleArrayQueue1<Integer> queue = new CircleArrayQueue1<>(5);
        queue.offer(1);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.offer(2);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.offer(3);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.offer(4);
        queue.offer(5);
    }

    @Test
    public void testPoll() {
        CircleArrayQueue1<Integer> queue = new CircleArrayQueue1<>(5);
        queue.offer(1);
        assertEquals(Integer.valueOf(1), queue.poll());
        queue.offer(2);
        assertEquals(Integer.valueOf(2), queue.poll());
        queue.offer(3);
        assertEquals(Integer.valueOf(3), queue.poll());
        queue.offer(4);
        queue.offer(5);
    }

    @Test
    public void testLimitCapacity() {
        CircleArrayQueue1<Integer> queue = new CircleArrayQueue1<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertFalse(queue.offer(4));
        assertFalse(queue.offer(5));
    }
}
