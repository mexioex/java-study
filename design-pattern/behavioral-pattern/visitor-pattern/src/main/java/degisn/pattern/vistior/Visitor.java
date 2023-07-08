package degisn.pattern.vistior;

/**
 * 访问者
 *
 * @author mexioex
 * @date 2023-07-08
 */
public interface Visitor {
    /**
     * 访问具体的硬件
     *
     * @param hardware 访问的硬件
     */
    void visit(Hardware hardware);
}
