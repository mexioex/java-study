package se.oop.polymorphic;

/**
 * 动物类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Animal {
    private Integer age;
    private String color;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat(String something) {
    }

    public Animal(Integer age, String color) {
        this.age = age;
        this.color = color;
    }
}
