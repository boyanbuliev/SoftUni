package robotService.models.garages;

import robotService.common.ExceptionMessages;
import robotService.models.garages.interfaces.Garage;
import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private static final int CAPACITY = 10;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }

    @Override
    public void manufacture(Robot robot) {
        if (robots.size() == CAPACITY) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        if (robots.containsKey(robot.getName())) {
            throw new IllegalArgumentException(String.format(
                    EXISTING_ROBOT, robot.getName()));
        }
        robots.put(robot.getName(), robot);
    }

    @Override
    public void sell(String robotName, String ownerName) {
        if (!robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        this.robots.get(robotName).setBought(true);
        this.robots.get(robotName).setOwner(ownerName);
        this.robots.remove(robotName);
    }
}
