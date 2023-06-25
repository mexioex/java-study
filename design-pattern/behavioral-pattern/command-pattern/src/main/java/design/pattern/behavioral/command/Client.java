package design.pattern.behavioral.command;

/**
 * 模拟客户端
 *
 * @author mexioex
 * @date 2023-06-25
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new DefaultReceiverImpl(new PaintCommand());
        receiver.action();
    }
}
