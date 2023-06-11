package se.oop.abstracts;

/**
 * 青蛙
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Frog extends Animal {

    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    void eat(String food) {
        System.out.println("青蛙吃虫子");
    }
}
