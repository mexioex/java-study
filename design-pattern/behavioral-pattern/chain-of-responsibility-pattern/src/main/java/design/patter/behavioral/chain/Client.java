package design.patter.behavioral.chain;

/**
 * 客户端
 *
 * @author mexioex
 * @date 2023-06-15
 */
public class Client {
    public static void main(String[] args) {
        Excuse excuse = new Excuse("小明", "身体不适", 7);
        // 设置处理器链
        GroupHandler groupHandler = new GroupHandler();
        MangerHandler mangerHandler = new MangerHandler();
        GeneralMangerHandler generalMangerHandler = new GeneralMangerHandler();
        groupHandler.setNextHandler(mangerHandler);
        mangerHandler.setNextHandler(generalMangerHandler);
        groupHandler.submit(excuse);
    }
}
