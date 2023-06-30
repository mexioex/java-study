package design.pattern.behavioral.interprter;

/**
 * 抽象表达式类
 *
 * @author mexioex
 * @date 2023-06-26
 */
public abstract class AbstractExpression {
    public abstract int interpret(Context context);
}
