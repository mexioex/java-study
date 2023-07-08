package design.pattern.strategy;

/**
 * 环境类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Person {
    private Strategy strategy;

    public void changeState(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        strategy.doWork();
    }

}
