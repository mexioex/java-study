package se.oop.abstracts;

/**
 * 羊
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Sheep extends Animal {

    public Sheep() {
        super();
    }

    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    void eat(String food) {
        System.out.println("羊吃草");
    }
}
