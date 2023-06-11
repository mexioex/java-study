package se.oop.statics;

/**
 * static关键字的使用
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class StaticUsage {
    static {
        System.out.println("静态代码块");
    }

    // 静态变量
    static int a = 1;
    // 静态常量
    static final int b = 1;

    // 静态方法
    public static void method() {
        System.out.println("我是静态方法");
    }
}
