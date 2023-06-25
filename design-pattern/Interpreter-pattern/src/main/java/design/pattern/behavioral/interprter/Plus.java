package design.pattern.behavioral.interprter;

/**
 * 加法表达式类
 *
 * @author mexioex
 * @date 2023-06-26
 */
public class Plus extends AbstractExpression {
    /**
     * 加号左边的表达式
     */
    private final AbstractExpression left;

    /**
     * 加号右边边的表达式
     */
    private final AbstractExpression right;

    @Override
    public int interpret(Context context) {
        // 将左边表达式的结果和右边表达式的结果相加
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "+" + right.toString() + ")";
    }

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }
}
