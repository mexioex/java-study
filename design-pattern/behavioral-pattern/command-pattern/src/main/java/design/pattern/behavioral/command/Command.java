package design.pattern.behavioral.command;

/**
 * 命令抽象类,声明执行的抽象方法
 *
 * @author mexioex
 * @date 2023-06-25
 */
public interface Command {
    /**
     * 执行命令,由具体命令实现
     */
    void execute();
}
