package degisn.pattern.state;

/**
 * 开心状态类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Happy extends State {
    @Override
    void doWork() {
        System.out.println("积极工作!");
    }
}
