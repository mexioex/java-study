package design.pattern.creational.factory.method;

import design.pattern.creational.factory.method.product.Vehicle;

/**
 * 抽象汽车工厂,创建了 Vehicle 类结构之后就可以创建抽象工厂,工厂类不包含任何创建实例的代码
 *
 * @author mexioex
 * @date 2023-06-09
 */
public abstract class VehicleFactory {
    protected abstract Vehicle createdVehicle(String size);

    public Vehicle orderVehicle(String size, String color) {
        Vehicle vehicle = createdVehicle(size);
        vehicle.setColor(color);
        vehicle.testVehicle();
        return vehicle;
    }
}
