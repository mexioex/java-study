package design.pattern.creational.factory.method.product;

/**
 * 小自行车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SmallBike extends Vehicle {

    @Override
    public void testVehicle() {
        System.out.println("SportCar color is: " + color + ",size is: " + size);
    }

    public SmallBike(String size) {
        super();
        this.size = size;
    }
}
