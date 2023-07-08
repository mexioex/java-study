package design.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 塔台实现类
 *
 * @author mexioex
 * @date 2023-07-08
 */
public class ControlTowerImpl implements ControlTower {
    List<Aircraft> aircraftList = new ArrayList<>();

    @Override
    public void register(Aircraft aircraft) {
        this.aircraftList.add(aircraft);
    }

    @Override
    public void land(Aircraft landAircraft) {
        for (Aircraft currentAircraft : this.aircraftList) {
            if (!currentAircraft.isLanding()) {
                continue;
            }
            if (currentAircraft.getName().equals(landAircraft.getName())) {
                System.out.println(landAircraft.getName() + ": 正在落地");
                break;
            }
            System.out.println("当前: " + currentAircraft.getName() + ",正在申请落地" + ", " + landAircraft.getName() + ", 请稍后重试");
        }
    }
}
