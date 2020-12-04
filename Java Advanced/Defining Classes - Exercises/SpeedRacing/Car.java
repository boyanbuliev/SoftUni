package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double cost;
    private int distance = 0;

    public Car(String model, double fuel, double cost) {
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
    }

    public boolean drive(int kmToTravel) {
        if (this.fuel / this.cost >= kmToTravel) {
            this.fuel -= kmToTravel * this.cost;
            this.distance += kmToTravel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
