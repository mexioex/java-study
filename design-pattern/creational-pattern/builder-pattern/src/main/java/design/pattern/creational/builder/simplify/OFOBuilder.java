package design.pattern.creational.builder.simplify;

/**
 * 摩拜单车构建器
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class OFOBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
