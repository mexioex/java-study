package design.pattern.creational.factory.method.product;

/**
 * 大卡车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class SmallTruck extends Vehicle {

    public SmallTruck(String size) {
        super();
        this.size = size;
    }

    @Override
    public void testVehicle() {
        System.out.println("SmallTruck color is: " + super.color + ",size is: " + size);
    }
}
