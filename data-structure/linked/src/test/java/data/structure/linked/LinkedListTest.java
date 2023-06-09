package data.structure.linked;

import org.junit.Test;

/**
 * 单向链表测试
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class LinkedListTest {
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
        singleLinkedList.forEach(System.out::println);
        int i = singleLinkedList.get(2);
        System.out.println(i);
    }

    @Test
    public void doubleLinkedListTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(12);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addFirst(10);
        doubleLinkedList.insert(2, 18);
        doubleLinkedList.removeFirst();
        doubleLinkedList.removeLast();
        doubleLinkedList.remove(1);
        for (Integer integer : doubleLinkedList) {
            System.out.println(integer);
        }
        doubleLinkedList.forEach(System.out::println);
        int i = doubleLinkedList.get(2);
        System.out.println(i);
    }

    @Test
    public void circleDoubleLinkedListTest() {
        CircleDoubleLinkedList circleDoubleLinkedList = new CircleDoubleLinkedList();
        circleDoubleLinkedList.addLast(12);
        circleDoubleLinkedList.addFirst(1);
        circleDoubleLinkedList.addFirst(2);
        circleDoubleLinkedList.addFirst(3);
        circleDoubleLinkedList.addFirst(4);
        circleDoubleLinkedList.addFirst(5);
        circleDoubleLinkedList.addFirst(10);
        circleDoubleLinkedList.insert(2, 18);
        circleDoubleLinkedList.removeFirst();
        circleDoubleLinkedList.removeLast();
        circleDoubleLinkedList.removeByValue(1);
        circleDoubleLinkedList.remove(1);
        for (Integer integer : circleDoubleLinkedList) {
            System.out.println(integer);
        }
        circleDoubleLinkedList.forEach(System.out::println);
        int i = circleDoubleLinkedList.get(2);
        System.out.println(i);
    }

}