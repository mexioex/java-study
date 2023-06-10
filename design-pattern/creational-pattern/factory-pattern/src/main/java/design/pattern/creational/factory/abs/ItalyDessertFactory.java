package design.pattern.creational.factory.abs;

import design.pattern.creational.factory.abs.product.Coffee;
import design.pattern.creational.factory.abs.product.Dessert;
import design.pattern.creational.factory.abs.product.LatteCoffee;
import design.pattern.creational.factory.abs.product.Tiramisu;

/**
 * 意式甜点具体工厂
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class ItalyDessertFactory implements DessertFactory {
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    public Dessert createDessert() {
        return new Tiramisu();
    }
}