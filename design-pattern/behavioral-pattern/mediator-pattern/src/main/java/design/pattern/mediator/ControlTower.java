package design.pattern.mediator;

/**
 * 抽象塔塔
 *
 * @author mexioex
 * @date 2023-07-08
 */
public interface ControlTower {
    /**
     * 注册飞机到塔台
     *
     * @param aircraft 飞机实体
     */
    void register(Aircraft aircraft);

    /**
     * 塔台申请飞机着落
     *
     * @param aircraft 飞机
     */
    void land(Aircraft aircraft);
}
