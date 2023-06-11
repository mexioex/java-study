package se.oop.polymorphic;

/**
 * 饲养员类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void keepPet(Animal animal) {
        if (animal instanceof Cat cat) {
            System.out.println("年龄为: " + age + "的" + name + "养了一只" + animal.getColor() + "的猫");
            cat.eat("鱼");
        }

        if (animal instanceof Dog dog) {
            System.out.println("年龄为: " + age + "的" + name + "养了一只" + animal.getColor() + "的狗");
            dog.eat("骨头");
        }
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
