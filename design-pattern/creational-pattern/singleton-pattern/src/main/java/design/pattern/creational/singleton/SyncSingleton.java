package design.pattern.creational.singleton;

/**
 * 同步单例模式，解决基本单例模式多线程环境下会产生多个实例
 *
 * @author mexioex
 * @date 2023-06-7
 */
public class SyncSingleton {
    private static SyncSingleton instance;

    /**
     * 单例模式不允许直接实例化
     */
    private SyncSingleton() {
        System.out.println("singleton is instantiated.");
    }

    public static synchronized SyncSingleton getInstance() {
        if (instance == null) {
            instance = new SyncSingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Something is Done.");
    }
}