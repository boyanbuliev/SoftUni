package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (data.size() > 0) {
            Car latestCar = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (latestCar.getYear() < data.get(i).getYear()) {
                    latestCar = data.get(i);
                }
            }
            return latestCar;
        } else {
            return null;
        }
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ")
                .append(this.type)
                .append(":")
                .append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car)
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
