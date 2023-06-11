package se.oop.polymorphic;

/**
 * 猫
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Cat extends Animal {

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "岁" + getColor() + "猫吃:" + something);
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }

    public Cat(Integer age, String color) {
        super(age, color);
    }
}
