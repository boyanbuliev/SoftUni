package vehicles2;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 0.9) * distance;
        if (fuelCost <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km",
                    this.getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }
}
