package data.structure.linked;

import org.junit.Test;

import java.util.Iterator;

/**
 * 单向链表测试
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SingleLinkedListTest {
    @Test
    public void singleLinkedListTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(12);
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.addFirst(5);
        singleLinkedList.addFirst(10);
        singleLinkedList.insert(18, 2);
        singleLinkedList.removeFirst();
        singleLinkedList.remove(1);
        for (Integer integer : singleLinkedList) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = singleLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        singleLinkedList.forEach(System.out::println);

        int i = singleLinkedList.get(2);
        System.out.println(i);
    }

    @Test
    public void sentinelSingleLinkedListTest() {
        SentinelSingleLinkedList singleLinkedList = new SentinelSingleLinkedList();
        singleLinkedList.addLast(12);
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.addFirst(5);
        singleLinkedList.addFirst(10);
        singleLinkedList.insert(18, 2);
        singleLinkedList.removeFirst();
        singleLinkedList.remove(1);
        for (Integer integer : singleLinkedList) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = singleLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        singleLinkedList.forEach(System.out::println);

        int i = singleLinkedList.get(2);
        System.out.println(i);
    }

}