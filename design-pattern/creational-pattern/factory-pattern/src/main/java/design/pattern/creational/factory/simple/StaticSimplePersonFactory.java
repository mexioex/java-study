package design.pattern.creational.factory.simple;

import design.pattern.creational.factory.simple.product.*;

/**
 * 人类工厂,显然这种方式如果 Person 多了一个新实现类,我们就需要新增新的实例方法
 * 这样又违反了《开闭原则》
 * 可以通过一下两种方式优化:
 * 1.使用反射机制注册人类对象和实例化
 * 2.注册人类对象并且向每个产品添加 newInstance 方法,该方法返回与自身类型相同的实例
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class StaticSimplePersonFactory {
    public enum PersonType {
        Boy, Man, Girl, Woman
    }

    public static Person create(PersonType personType) {
        return switch (personType) {
            case Boy -> new Boy();
            case Man -> new Man();
            case Girl -> new Girl();
            case Woman -> new Woman();
        };
    }
}
