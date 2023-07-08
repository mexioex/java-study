package design.pattern.memo;

/**
 * 汽车状态管理者
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class CarCaretaker {
    public static void main(String[] args) {
        new CarCaretaker().runMechanicTest();
    }

    public void runMechanicTest() {
        CarOriginator.Memento saveState;
        CarOriginator carOriginator = new CarOriginator();
        carOriginator.setState("state1");
        carOriginator.setState("state2");
        saveState = carOriginator.saveState();
        carOriginator.setState("state3");
        carOriginator.restoreState(saveState);
        System.out.println("final state:" + carOriginator.getState());
    }
}
