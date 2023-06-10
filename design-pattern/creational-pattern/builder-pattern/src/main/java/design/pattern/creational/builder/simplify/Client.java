package design.pattern.creational.builder.simplify;


/**
 * 客户端测试类
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Client {
    public static void main(String[] args) {
        Builder mobileBuilder = new MobileBuilder();
        Bike mobile = mobileBuilder.construct();
        Builder ofoBuilder = new OFOBuilder();
        Bike ofo = ofoBuilder.construct();
        System.out.println(mobile);
        System.out.println(ofo);
    }
}