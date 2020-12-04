package vehiclesextension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

@Override
    public String drive(double distance) {
        if ((this.getFuelConsumption() + 1.4) * distance <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - (this.getFuelConsumption() + 1.4) * distance);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return String.format("%s travelled %s km",
                    this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }
}
