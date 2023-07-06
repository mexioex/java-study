package design.pattern.observer;

/**
 * 主题抽象类
 *
 * @author mexioex
 * @date 2023-07-07
 */
public interface Subject {
    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    void attach(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void detach(Observer observer);

    /**
     * 通知观察者们
     */
    void notifyObserver();
}
