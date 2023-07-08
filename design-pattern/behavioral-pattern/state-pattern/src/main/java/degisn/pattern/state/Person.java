package degisn.pattern.state;

/**
 * 环境类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Person {
    private State state;

    public void changeState(State state) {
        this.state = state;
    }

    public void doSomething() {
        state.doWork();
    }

}
