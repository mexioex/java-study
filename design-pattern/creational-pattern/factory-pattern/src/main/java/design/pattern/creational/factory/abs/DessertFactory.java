package design.pattern.creational.factory.abs;

import design.pattern.creational.factory.abs.product.Coffee;
import design.pattern.creational.factory.abs.product.Dessert;

/**
 * 抽象工厂
 *
 * @author mexioex
 * @date 2023-06-10
 */
public interface DessertFactory {
    Coffee createCoffee();

    Dessert createDessert();
}