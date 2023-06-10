package design.pattern.creational.factory.method.product;

/**
 * 运动车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SportCar extends Vehicle {

    @Override
    public void testVehicle() {
        System.out.println("SportCar color is: " + color + ",size is: " + size);
    }

    public SportCar(String size) {
        super();
        this.size = size;
    }
}
