package algorithm.search;

/**
 * 二分查找算法
 *
 * @author mexioex
 * @date 2023-06-07
 */
public class BinarySearch {
    /**
     * @param array  待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引, 找不到返回-1
     */
    public static int binarySearch(int[] array, int target) {
        // 头指针
        int start = 0;
        // 尾指针
        int end = array.length;
        // 查找范围在 start 到 end 之间
        while (start < end) {
            // 取中间处的索引
            int mid = (start + end) >>> 1;
            // 目标值比中间值小,目标值左边,目标值比中间值大,目标值右边,相等说明找到
            if (target < array[mid]) {
                // 尾指针移动到 mid 之前
                end = mid;
            } else if (array[mid] < target) {
                // 头指针移动到 mid 之前
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找最对应值最左边的索引
     *
     * @param array  待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引, 找不到返回-1
     */
    public static int binarySearchLeftMost(int[] array, int target) {
        // 头指针
        int start = 0;
        // 尾指针
        int end = array.length;
        // 候选者
        int candidate = -1;
        // 查找范围在 start 到 end 之间
        while (start < end) {
            // 取中间处的索引
            int mid = (start + end) >>> 1;
            // 目标值比中间值小,目标值左边,目标值比中间值大,目标值右边,相等说明找到
            if (target < array[mid]) {
                // 尾指针移动到 mid 之前
                end = mid;
            } else if (array[mid] < target) {
                // 头指针移动到 mid 之前
                start = mid + 1;
            } else {
                // 记录候选位置
                candidate = mid;
                end = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 查找最对应值最右边的索引
     *
     * @param array  待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引, 找不到返回-1
     */
    public static int binarySearchRightMost(int[] array, int target) {
        // 头指针
        int start = 0;
        // 尾指针
        int end = array.length;
        // 候选者
        int candidate = -1;
        // 查找范围在 start 到 end 之间
        while (start < end) {
            // 取中间处的索引
            int mid = (start + end) >>> 1;
            // 目标值比中间值小,目标值左边,目标值比中间值大,目标值右边,相等说明找到
            if (target < array[mid]) {
                // 尾指针移动到 mid 之前
                end = mid;
            } else if (array[mid] < target) {
                // 头指针移动到 mid 之前
                start = mid + 1;
            } else {
                // 记录候选位置
                candidate = mid;
                start = mid + 1;
            }
        }
        return candidate;
    }
}
