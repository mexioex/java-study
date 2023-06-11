package se.oop.abstracts;

/**
 * 狗
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Dog extends Animal {

    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void eat(String food) {
        System.out.println("狗吃肉");
    }
}
