package design.pattern.creational.singleton;

/**
 * 内部类单例模式
 *
 * @author mexioex
 * @date 2023-06-7
 */
public class HolderSingleton {

    /**
     * 单例模式不允许直接实例化
     */
    private HolderSingleton() {
        System.out.println("singleton is instantiated.");
    }

    private static final class InstanceHolder {
        private static final HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return InstanceHolder.instance;
    }

    public void doSomething() {
        System.out.println("Something is Done.");
    }
}
