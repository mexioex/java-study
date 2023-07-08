package degisn.pattern.vistior;

/**
 * 访问者实现类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class VisitorImpl implements Visitor {
    @Override
    public void visit(Hardware hardware) {
        hardware.command = "1+1=2";
    }
}
