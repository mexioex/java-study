package design.pattern.behavioral.interprter;

/**
 * 封装变量的类
 *
 * @author mexioex
 * @date 2023-06-26
 */
public class Variable extends AbstractExpression {
    /**
     * 变量名称
     */
    private final String name;

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }

    public Variable(String name) {
        this.name = name;
    }
}
