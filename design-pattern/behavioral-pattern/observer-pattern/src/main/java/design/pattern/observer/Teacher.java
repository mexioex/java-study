package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 教师类,负责修改作业
 *
 * @author mexioex
 * @date 2023-07-07
 */
public class Teacher implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach((Observer::update));
    }
}
