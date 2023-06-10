package design.pattern.creational.factory.simple;

import design.pattern.creational.factory.simple.product.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射机制简单人类工厂
 * 但是反射机制在某些情况下并不适用
 * 1.比如反射需要运行时权限,在特定环境下是无法实现的
 * 2.反射影响效率,高性能环境下不建议使用这种方式
 * 优化思路:
 * 1.人类做出一个抽象类,添加 newInstance 方法
 * 2.对于子类,每个实现类都可以创造自己的实例
 * 3.工厂类中的 Map 修改为对应的 Person对象
 *
 * @author mexioex
 * @date 2023-06-09
 */
public class StaticSimpleReflectPersonFactory {
    private final Map<String, Class<? extends Person>> registerPersons = new HashMap<>();

    public void registerPerson(String personId, Class<? extends Person> personClass) {
        registerPersons.put(personId, personClass);
    }

    public Person create(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Person> aClass = registerPersons.get(type);
        Constructor<? extends Person> constructor = aClass.getConstructor();
        return constructor.newInstance();
    }
}
