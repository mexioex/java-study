package design.pattern.creational.factory.simple.product;

/**
 * 男孩
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Boy extends Person {
    @Override
    public Boy newInstance() {
        return new Boy();
    }
}
