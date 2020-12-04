package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseProcedure implements Procedure {
    protected Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator());
        for (Robot robot : robots) {
            sb.append(robot)
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public abstract void doService(Robot robot, int procedureTime);
//        if (robot.getProcedureTime() < procedureTime) {
//            throw new IllegalArgumentException(ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME);
//        }
//        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
//        this.robots.add(robot);
//    }
}
