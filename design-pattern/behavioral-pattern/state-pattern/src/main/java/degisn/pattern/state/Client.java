package degisn.pattern.state;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        person.changeState(new Happy());
        person.doSomething();
        person.changeState(new Angry());
        person.doSomething();
        person.changeState(new Sad());
        person.doSomething();
    }
}
