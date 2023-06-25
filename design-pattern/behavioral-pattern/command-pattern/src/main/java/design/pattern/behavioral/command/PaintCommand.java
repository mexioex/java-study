package design.pattern.behavioral.command;

/**
 * 具体命令
 *
 * @author mexioex
 * @date 2023-06-25
 */
public class PaintCommand implements Command {
    @Override
    public void execute() {
        System.out.println("painting....");
    }
}
