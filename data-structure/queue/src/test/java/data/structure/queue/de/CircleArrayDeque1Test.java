package data.structure.queue.de;

import data.structure.queue.single.LinkedListQueue;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

/**
 * 队列测试
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class CircleArrayDeque1Test {
    @Test
    public void testOfferFirst() {
        CircleArrayDeque1<Integer> queue = new CircleArrayDeque1<>(3);
        queue.offerFirst(1);
        assertEquals(Integer.valueOf(1), queue.peekFirst());
        queue.offerFirst(2);
        assertEquals(Integer.valueOf(2), queue.peekFirst());
        queue.offerFirst(3);
        assertEquals(Integer.valueOf(3), queue.peekFirst());
        queue.offerFirst(4);
        queue.offerFirst(5);
    }

    @Test
    public void testOfferLast() {
        CircleArrayDeque1<Integer> queue = new CircleArrayDeque1<>(3);
        queue.offerLast(1);
        assertEquals(Integer.valueOf(1), queue.peekLast());
        queue.offerLast(2);
        assertEquals(Integer.valueOf(2), queue.peekLast());
        queue.offerLast(3);
        assertEquals(Integer.valueOf(3), queue.peekLast());
        queue.offerLast(4);
        queue.offerLast(5);
    }

    @Test
    public void testPollFirst() {
        CircleArrayDeque1<Integer> queue = new CircleArrayDeque1<>(3);
        queue.offerFirst(1);
        assertEquals(Integer.valueOf(1), queue.pollFirst());
        queue.offerFirst(2);
        assertEquals(Integer.valueOf(2), queue.pollFirst());
        queue.offerFirst(3);
        assertEquals(Integer.valueOf(3), queue.pollFirst());
        queue.offerFirst(4);
        queue.offerFirst(5);
    }

    @Test
    public void testPollLast() {
        CircleArrayDeque1<Integer> queue = new CircleArrayDeque1<>(3);
        queue.offerLast(1);
        assertEquals(Integer.valueOf(1), queue.pollLast());
        queue.offerLast(2);
        assertEquals(Integer.valueOf(2), queue.pollLast());
        queue.offerLast(3);
        assertEquals(Integer.valueOf(3), queue.pollLast());
        queue.offerLast(4);
        queue.offerLast(5);
    }

    @Test
    public void testLimitCapacity() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertFalse(queue.offer(4));
        assertFalse(queue.offer(5));
    }
}
