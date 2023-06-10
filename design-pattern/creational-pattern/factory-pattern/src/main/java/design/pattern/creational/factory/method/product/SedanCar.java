package design.pattern.creational.factory.method.product;

/**
 * 轿车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SedanCar extends Vehicle {

    public SedanCar(String size) {
        super();
        this.size = size;
    }

    @Override
    public void testVehicle() {
        System.out.println("SedanCar color is: " + super.color + ",size is: " + size);
    }
}
