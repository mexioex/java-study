package se.oop.interfaces;

/**
 * 动物抽象类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public abstract class Animal {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {

    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void drink() {
        System.out.println("动物都要喝水");
    }

    abstract void eat();
}
