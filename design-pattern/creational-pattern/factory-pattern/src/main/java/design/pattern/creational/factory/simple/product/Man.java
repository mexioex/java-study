package design.pattern.creational.factory.simple.product;

/**
 * 男性
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class Man extends Person {
    @Override
    public Man newInstance() {
        return new Man();
    }
}
