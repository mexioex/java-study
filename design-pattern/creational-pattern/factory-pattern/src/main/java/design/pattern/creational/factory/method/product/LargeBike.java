package design.pattern.creational.factory.method.product;

/**
 * 大自行车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class LargeBike extends Vehicle {

    @Override
    public void testVehicle() {
        System.out.println("SportCar color is: " + color + ",size is: " + size);
    }

    public LargeBike(String size) {
        super();
        this.size = size;
    }
}
