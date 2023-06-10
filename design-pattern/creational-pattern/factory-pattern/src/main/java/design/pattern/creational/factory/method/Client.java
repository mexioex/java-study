package design.pattern.creational.factory.method;

import design.pattern.creational.factory.method.product.SmallBike;
import design.pattern.creational.factory.method.product.SmallTruck;
import design.pattern.creational.factory.method.product.Vehicle;

/**
 * 客户端
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Client {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new CarFactory();
        vehicleFactory.orderVehicle("large", "blue");
        VehicleFactory truckFactory = new TruckFactory();
        truckFactory.orderVehicle("large", "blue");
        VehicleFactory bikeFactory = new VehicleFactory() {
            @Override
            protected Vehicle createdVehicle(String size) {
                if ("small".equals(size)) {
                    return new SmallBike(size);
                } else if ("large".equals(size)) {
                    return new SmallTruck(size);
                }
                return null;
            }
        };
        bikeFactory.orderVehicle("large", "blue");
    }
}
