package design.pattern.creational.singleton;


import org.junit.Test;

public class SingletonTest {
    @Test
    public void baseSingletonTest() {
        BaseSingleton.getInstance().doSomething();
    }

    @Test
    public void syncSingletonTest() {
        SyncSingleton.getInstance().doSomething();
    }

    @Test
    public void doubleCheckSingletonTest() {
        DoubleCheckSingleton.getInstance().doSomething();
    }

    @Test
    public void holderSingletonTest() {
        HolderSingleton.getInstance().doSomething();
    }
}
