package design.pattern.creational.prototype;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Client {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.name = "张三";
        Prototype clone = prototype.clone();
        prototype.name = "李四";
        System.out.println(prototype.name);
        System.out.println(clone.name);
    }
}
