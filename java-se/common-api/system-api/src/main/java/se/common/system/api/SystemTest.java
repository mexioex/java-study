package se.common.system.api;

import java.util.Arrays;

/**
 * 系统类测试
 *
 * @author mexioex
 * @date 2023-06-12
 */
public class SystemTest {
    public static void main(String[] args) {
        // 退出虚拟机
        // System.exit(0);
        // 获取当前时间的毫秒值
        long start = System.currentTimeMillis();
        System.out.println(start);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[3];
        // 数组copy
        System.arraycopy(array1, 0, array2, 0, 3);
        System.out.println(Arrays.toString(array2));
    }
}
