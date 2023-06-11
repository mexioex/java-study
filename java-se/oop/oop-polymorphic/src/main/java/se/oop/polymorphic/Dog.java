package se.oop.polymorphic;

/**
 * 狗
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Dog extends Animal {

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "岁" + getColor() + "狗吃:" + something);
    }

    public void lookHome() {
        System.out.println("狗看家");
    }

    public Dog(Integer age, String color) {
        super(age, color);
    }
}
