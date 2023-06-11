package se.oop.interfaces;

/**
 * 狗
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Dog extends Animal implements Swim {

    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    @Override
    public void swim() {
        System.out.println("狗会狗刨");
    }
}
