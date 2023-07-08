package design.pattern.strategy;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        person.changeState(new HappyStrategy());
        person.doSomething();
        person.changeState(new AngryStrategy());
        person.doSomething();
        person.changeState(new SadStrategy());
        person.doSomething();
    }
}
