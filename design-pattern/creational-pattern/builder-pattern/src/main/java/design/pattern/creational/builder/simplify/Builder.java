package design.pattern.creational.builder.simplify;

/**
 * 构建器
 *
 * @author mexioex
 * @date 2023-06-10
 */
public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();

    public Bike construct() {
        buildSeat();
        buildFrame();
        return createBike();
    }
}
