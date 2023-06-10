package design.pattern.creational.builder.base;

/**
 * 客户端测试类
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Client {
    public static void main(String[] args) {
        Director mobileDirector = new Director(new MobileBuilder());
        Bike mobileBike = mobileDirector.construct();
        System.out.println(mobileBike);
        Director ofoDirector = new Director(new OFOBuilder());
        Bike ofoBike = ofoDirector.construct();
        System.out.println(ofoBike);
    }
}
