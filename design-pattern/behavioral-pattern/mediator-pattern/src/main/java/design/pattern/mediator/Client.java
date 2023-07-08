package design.pattern.mediator;

/**
 * 测试类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Client {
    public static void main(String[] args) {
        ControlTower controlTower = new ControlTowerImpl();
        Aircraft aircraft1 = new Aircraft("波音747", false, controlTower);
        Aircraft aircraft2 = new Aircraft("波音748", true, controlTower);
        controlTower.register(aircraft1);
        controlTower.register(aircraft2);
        aircraft1.requestLand();
    }
}
