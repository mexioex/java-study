package design.pattern.creational.factory.method;

import design.pattern.creational.factory.method.product.SedanCar;
import design.pattern.creational.factory.method.product.SportCar;
import design.pattern.creational.factory.method.product.Vehicle;

/**
 * 汽车工厂类实现实例化汽车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle createdVehicle(String size) {
        if ("small".equals(size)) {
            return new SportCar(size);
        } else if ("large".equals(size)) {
            return new SedanCar(size);
        }
        return null;
    }
}