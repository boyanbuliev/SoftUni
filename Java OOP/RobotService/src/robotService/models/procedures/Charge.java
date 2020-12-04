package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Charge extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
        this.robots.add(robot);
    }
}
