package design.pattern.strategy;

/**
 * 悲伤状态
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class SadStrategy extends Strategy {
    @Override
    void doWork() {
        System.out.println("啥也不干!!");
    }
}
