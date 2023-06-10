package design.pattern.creational.factory.method.product;

/**
 * 大卡车
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class LargeTruck extends Vehicle {

    public LargeTruck(String size) {
        super();
        this.size = size;
    }

    @Override
    public void testVehicle() {
        System.out.println("LargeTruck color is: " + super.color + ",size is: " + size);
    }
}
