package design.pattern.strategy;

/**
 * 分录状态
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class AngryStrategy extends Strategy {
    @Override
    void doWork() {
        System.out.println("无精打采!!");
    }
}
