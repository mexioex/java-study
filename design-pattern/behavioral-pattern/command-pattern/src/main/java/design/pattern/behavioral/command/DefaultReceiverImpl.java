package design.pattern.behavioral.command;

/**
 * 默认接受命令实现
 *
 * @author mexioex
 * @date 2023-06-25
 */
public class DefaultReceiverImpl implements Receiver {
    private final Command command;

    @Override
    public void action() {
        command.execute();
    }

    public DefaultReceiverImpl(Command command) {
        this.command = command;
    }
}
