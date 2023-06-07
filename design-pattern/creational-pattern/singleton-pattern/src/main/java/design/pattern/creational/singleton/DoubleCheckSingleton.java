package design.pattern.creational.singleton;

/**
 * 双检查单例模式
 *
 * @author mexioex
 * @date 2023-06-7
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;

    /**
     * 单例模式不允许直接实例化
     */
    private DoubleCheckSingleton() {
        System.out.println("singleton is instantiated.");
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Something is Done.");
    }
}
