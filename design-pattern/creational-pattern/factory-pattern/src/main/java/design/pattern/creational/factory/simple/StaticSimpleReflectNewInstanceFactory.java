package design.pattern.creational.factory.simple;

import design.pattern.creational.factory.simple.product.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * newInstance方法,简单人类工厂
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class StaticSimpleReflectNewInstanceFactory {
    private final Map<String, Person> registerPersons = new HashMap<>();

    public void registerPerson(String personId, Person person) {
        registerPersons.put(personId, person);
    }

    public Person create(String type) {
        return registerPersons.get(type).newInstance();
    }
}