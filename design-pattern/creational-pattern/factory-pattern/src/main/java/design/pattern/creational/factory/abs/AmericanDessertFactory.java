package design.pattern.creational.factory.abs;

import design.pattern.creational.factory.abs.product.AmericanCoffee;
import design.pattern.creational.factory.abs.product.Coffee;
import design.pattern.creational.factory.abs.product.Dessert;
import design.pattern.creational.factory.abs.product.MatchMousse;

/**
 * 美式甜点具体工厂
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class AmericanDessertFactory implements DessertFactory {
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    public Dessert createDessert() {
        return new MatchMousse();
    }
}