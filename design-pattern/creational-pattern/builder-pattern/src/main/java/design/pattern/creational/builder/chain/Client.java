package design.pattern.creational.builder.chain;


/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("英特尔")
                .memory("8G")
                .screen("京东方")
                .motherBoard("麒麟9000")
                .build();
        System.out.println(phone);
    }
}
