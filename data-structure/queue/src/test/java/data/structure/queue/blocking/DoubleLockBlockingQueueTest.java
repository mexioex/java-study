package data.structure.queue.blocking;

import data.structure.queue.block.DoubleLockBlockingQueue;
import org.junit.Test;

/**
 * 阻塞队列测试
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class DoubleLockBlockingQueueTest {
    @Test
    public void testOfferFirst() throws InterruptedException {
        DoubleLockBlockingQueue<String> queue = new DoubleLockBlockingQueue<>(3);
        new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " begin");
                queue.offer("任务一");
                System.out.println(queue);
                queue.offer("任务二");
                System.out.println(queue);
                queue.offer("任务三");
                System.out.println(queue);
                queue.offer("任务4", 5000);
                System.out.println(queue);
                System.out.println(System.currentTimeMillis() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者").start();
        Thread.sleep(2000);
        queue.poll();
    }
}
