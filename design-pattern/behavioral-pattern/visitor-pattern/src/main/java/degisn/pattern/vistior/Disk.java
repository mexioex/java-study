package degisn.pattern.vistior;

/**
 * CPU 硬件的一个实现
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Disk extends Hardware {
    public Disk(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}