package degisn.pattern.vistior;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Client {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.calculate();
        robot.accept(new VisitorImpl());
        robot.calculate();
    }
}
