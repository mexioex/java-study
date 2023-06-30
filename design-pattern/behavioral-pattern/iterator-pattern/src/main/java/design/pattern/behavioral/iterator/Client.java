package design.pattern.behavioral.iterator;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-06-30
 */
public class Client {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d"};
        StringArray stringArray = new StringArray(array);
        Iterator<String> iterator = stringArray.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
