package design.pattern.creational.factory.simple.product;

/**
 * 女孩
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Girl extends Person {
    @Override
    public Girl newInstance() {
        return new Girl();
    }
}
