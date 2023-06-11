package se.oop.polymorphic;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("老王", 19);
        person.keepPet(new Dog(1, "黑"));
        person.keepPet(new Cat(2, "白"));
    }
}
