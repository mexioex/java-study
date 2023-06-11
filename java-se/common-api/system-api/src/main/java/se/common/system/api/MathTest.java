package se.common.system.api;

/**
 * Math类测试
 *
 * @author mexioex
 * @date 2023-06-12
 */
public class MathTest {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(88));
        System.out.println(Math.abs(-88));
        System.out.println(Math.abs(-2147483647));
        // 进一法
        System.out.println(Math.ceil(12.34));
        System.out.println(Math.ceil(12.54));
        System.out.println(Math.ceil(-12.34));
        System.out.println(Math.ceil(-12.54));
        // 去尾法
        System.out.println(Math.floor(12.34));
        System.out.println(Math.floor(12.54));
        System.out.println(Math.floor(-12.34));
        System.out.println(Math.floor(-12.54));
        // 四舍五入
        System.out.println(Math.round(12.34));
        System.out.println(Math.round(12.54));
        System.out.println(Math.round(-12.34));
        System.out.println(Math.round(-12.54));
        // 获取最大值
        System.out.println(Math.max(30, 25));
        // 获取最小值
        System.out.println(Math.min(30, 25));
        // 获取a的b次幂
        System.out.println(Math.pow(4, 2));
        System.out.println(Math.pow(4, 0.5));
        System.out.println(Math.pow(4, -2));
        // 开平方
        System.out.println(Math.sqrt(4));
        // 开立方
        System.out.println(Math.cbrt(8));
        // 100 以内的随机数
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print((Math.floor(Math.random() * 100) + 1) + ",");
        }
    }
}
