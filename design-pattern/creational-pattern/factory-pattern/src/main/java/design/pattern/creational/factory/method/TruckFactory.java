package design.pattern.creational.factory.method;

import design.pattern.creational.factory.method.product.*;

/**
 * 汽车工厂类实现实例化汽车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class TruckFactory extends VehicleFactory {
    @Override
    protected Vehicle createdVehicle(String size) {
        if ("small".equals(size)) {
            return new SmallTruck(size);
        } else if ("large".equals(size)) {
            return new LargeTruck(size);
        }
        return null;
    }
}