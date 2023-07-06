package design.pattern.observer;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-07
 */
public class Client {
    public static void main(String[] args) {
        Sudent zs = new Sudent("张三");
        Sudent lisi = new Sudent("李四");
        Teacher teacher = new Teacher();
        teacher.attach(zs);
        teacher.attach(lisi);
        teacher.notifyObserver();
        teacher.detach(zs);
        teacher.notifyObserver();
    }
}
