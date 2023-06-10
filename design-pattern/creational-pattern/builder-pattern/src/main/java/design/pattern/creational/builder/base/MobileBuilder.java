package design.pattern.creational.builder.base;

/**
 * 摩拜单车构建器
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳钎维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮沙发");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
