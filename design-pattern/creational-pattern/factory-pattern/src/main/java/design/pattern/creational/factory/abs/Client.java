package design.pattern.creational.factory.abs;

import design.pattern.creational.factory.abs.product.Coffee;
import design.pattern.creational.factory.abs.product.Dessert;

/**
 * 客户端
 *
 * @author mexioex
 * @date 2023-06-10
 */
public class Client {
    public static void main(String[] args) {
        DessertFactory americanDessertFactory = new AmericanDessertFactory();
        Coffee coffee = americanDessertFactory.createCoffee();
        Dessert dessert = americanDessertFactory.createDessert();
        System.out.println(coffee);
        System.out.println(dessert);
        DessertFactory italyDessertFactory = new ItalyDessertFactory();
        Coffee italyDessertFactoryCoffee = italyDessertFactory.createCoffee();
        Dessert italyDessertFactoryDessert = italyDessertFactory.createDessert();
        System.out.println(italyDessertFactoryDessert);
        System.out.println(italyDessertFactoryCoffee);
    }
}
