package degisn.pattern.state;

/**
 * 分录状态
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Angry extends State {
    @Override
    void doWork() {
        System.out.println("无精打采!!");
    }
}
