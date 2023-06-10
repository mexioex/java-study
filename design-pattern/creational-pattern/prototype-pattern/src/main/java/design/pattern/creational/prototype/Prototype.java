package design.pattern.creational.prototype;

/**
 * 原型对象
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Prototype implements Cloneable {
    String name;

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
