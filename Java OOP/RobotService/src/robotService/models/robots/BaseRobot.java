package robotService.models.robots;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INVALID_ENERGY;
import static robotService.common.ExceptionMessages.INVALID_HAPPINESS;

public abstract class BaseRobot implements Robot {
    private static final String DEFAULT_OWNER = "Service";
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner;
    private boolean isBought;
    private boolean isRepaired;

    protected BaseRobot(String name, int energy, int happiness, int procedureTime) {
        this.name = name;
        this.setEnergy(energy);
        this.setHappiness(happiness);
        this.setProcedureTime(procedureTime);
        this.owner = DEFAULT_OWNER;
        this.isBought = false;
        this.isRepaired = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public void setHappiness(int happiness) {
        validateIntegerValue(happiness, INVALID_HAPPINESS);
        this.happiness = happiness;
    }

    private void validateIntegerValue(int value, String message) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        validateIntegerValue(energy, INVALID_ENERGY);
        this.energy = energy;
    }

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime = procedureTime;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setBought(boolean bought) {
        this.isBought = bought;
    }

    @Override
    public boolean isRepaired() {
        return this.isRepaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        this.isRepaired = repaired;
    }

    @Override
    public String toString() {
        return String.format(" Robot type: %s - %s - Happiness: %s - Energy: %s",
                this.getClass().getSimpleName(), this.getName(), this.getHappiness(), this.getEnergy());
    }
}
