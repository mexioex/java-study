package se.oop.interfaces;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("张三", 1);
        Frog frog = new Frog("李四", 1);
        dog.drink();
        dog.eat();
        dog.swim();
        frog.drink();
        frog.eat();
        frog.swim();
    }
}
