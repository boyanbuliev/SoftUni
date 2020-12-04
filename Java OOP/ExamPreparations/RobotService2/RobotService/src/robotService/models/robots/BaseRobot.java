package robotService.models.robots;

import robotService.models.robots.interfaces.Robot;

public class BaseRobot implements Robot {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getHappiness() {
        return 0;
    }

    @Override
    public void setHappiness(int happiness) {

    }

    @Override
    public int getEnergy() {
        return 0;
    }

    @Override
    public void setEnergy(int energy) {

    }

    @Override
    public int getProcedureTime() {
        return 0;
    }

    @Override
    public void setProcedureTime(int procedureTime) {

    }

    @Override
    public void setOwner(String owner) {

    }

    @Override
    public void setBought(boolean bought) {

    }

    @Override
    public boolean isRepaired() {
        return false;
    }

    @Override
    public void setRepaired(boolean repaired) {

    }
}
