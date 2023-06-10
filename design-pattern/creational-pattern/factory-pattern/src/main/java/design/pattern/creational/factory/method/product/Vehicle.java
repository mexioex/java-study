package design.pattern.creational.factory.method.product;

/**
 * 汽车抽象类
 *
 * @author mexioex
 * @date 2023-06-09
 */
public abstract class Vehicle {
    protected String color;

    protected String size;

    public abstract void testVehicle();

    public void setColor(String color) {
        this.color = color;
    }
}
