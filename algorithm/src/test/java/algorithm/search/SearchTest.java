package algorithm.search;

import org.junit.Test;

/**
 * 查找算法测试
 *
 * @author mexioex
 * @date 2023-06-07
 */
public class SearchTest {
    @Test
    public void binarySearchTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(BinarySearch.binarySearch(array, 30));
    }
}
