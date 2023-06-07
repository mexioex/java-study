package design.pattern.creational.singleton;

/**
 * 基本单例模式
 *
 * @author mexioex
 * @date 2023-06-7
 */
public class BaseSingleton {
    private static BaseSingleton instance;

    /**
     * 单例模式不允许直接实例化
     */
    private BaseSingleton() {
        System.out.println("singleton is instantiated.");
    }

    public static BaseSingleton getInstance() {
        if (instance == null) {
            instance = new BaseSingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Something is Done.");
    }
}
