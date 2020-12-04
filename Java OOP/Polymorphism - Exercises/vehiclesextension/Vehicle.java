package vehiclesextension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        if (this.fuelConsumption * distance <= this.fuelQuantity) {
            this.fuelQuantity -= this.fuelConsumption * distance;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return String.format("%s travelled %s km",
                    this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + fuel > this.tankCapacity) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuel;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
