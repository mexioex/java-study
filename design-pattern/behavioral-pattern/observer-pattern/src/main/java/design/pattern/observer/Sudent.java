package design.pattern.observer;

/**
 * 学生交作业
 *
 * @author mexioex
 * @date 2023-07-07
 */
public class Sudent implements Observer {
    private final String name;

    @Override
    public void update() {
        System.out.println(name + " : 作业修改了");
    }

    public Sudent(String name) {
        this.name = name;
    }
}
