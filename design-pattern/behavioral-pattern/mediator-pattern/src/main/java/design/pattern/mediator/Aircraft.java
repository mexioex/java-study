package design.pattern.mediator;

/**
 * 抽象飞机
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class Aircraft {
    private String name;
    private boolean isLanding;
    private ControlTower controlTower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLanding() {
        return isLanding;
    }

    public void setLanding(boolean landing) {
        isLanding = landing;
    }

    public ControlTower getControlTower() {
        return controlTower;
    }

    public void setControlTower(ControlTower controlTower) {
        this.controlTower = controlTower;
    }

    public void requestLand() {
        System.out.println(name + ": " + "申请降落");
        this.isLanding = true;
        controlTower.land(this);
    }

    public Aircraft(String name, boolean isLanding, ControlTower controlTower) {
        this.name = name;
        this.isLanding = isLanding;
        this.controlTower = controlTower;
    }
}
