package se.oop.abstracts;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Test {
    public static void main(String[] args) {
        Animal dog = new Dog("张三",1);
        Animal frog = new Frog("李四",1);
        Animal sheep = new Sheep("王五",1);
        dog.drink();
        dog.eat("肉");
        frog.drink();
        frog.eat("肉");
        sheep.drink();
        sheep.eat("肉");
    }
}
