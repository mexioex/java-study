package design.pattern.creational.builder.base;

/**
 * 单车处理者
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildSeat();
        builder.buildFrame();
        return builder.createBike();
    }
}
