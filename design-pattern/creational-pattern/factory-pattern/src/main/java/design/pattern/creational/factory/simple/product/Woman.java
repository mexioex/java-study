package design.pattern.creational.factory.simple.product;

/**
 * 女性
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Woman extends Person {
    @Override
    public Woman newInstance() {
        return new Woman();
    }
}
