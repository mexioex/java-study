package degisn.pattern.state;

/**
 * 悲伤状态
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Sad extends State {
    @Override
    void doWork() {
        System.out.println("啥也不干!!");
    }
}
