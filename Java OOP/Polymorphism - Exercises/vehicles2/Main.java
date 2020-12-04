package vehicles2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = bf.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String[] truckInfo = bf.readLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int n = Integer.parseInt(bf.readLine());

        while (n-- > 0) {
            String[] tokens = bf.readLine().split("\\s+");
            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    } else {
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "Refuel":
                    if (tokens[1].equals("Car")) {
                        car.refuel(Double.parseDouble(tokens[2]));
                    } else {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;
            }
        }
        System.out.println(car);    
        System.out.println(truck);
    }
}

