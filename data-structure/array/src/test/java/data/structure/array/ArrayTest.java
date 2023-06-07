package data.structure.array;

import org.junit.Test;

/**
 * 数组测试
 *
 * @author mexioex
 * @date 2023-06-07
 */
public class ArrayTest {
    @Test
    public void dynamicArrayTest() {
        DynamicArray integers = new DynamicArray();
        System.out.println(integers.isEmpty());
        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }
        integers.set(0, 15);
        System.out.println(integers.size());

        integers.add(0, 11);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(integers.remove());
        }
    }
}
