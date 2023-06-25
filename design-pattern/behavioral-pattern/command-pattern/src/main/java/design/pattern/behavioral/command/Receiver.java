package design.pattern.behavioral.command;

/**
 * 负责执行与命令关联的类
 *
 * @author mexioex
 * @date 2023-06-25
 */
public interface Receiver {
    /**
     * 接受命令进行操作
     */
    void action();
}
