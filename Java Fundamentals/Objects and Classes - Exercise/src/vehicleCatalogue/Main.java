package vehicleCatalogue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Vehicle> vehicles = new ArrayList<>();


        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            Vehicle vehicle;
            if ("car".equals(type)) {
                vehicle = new Vehicle("Car", model, color, horsepower);
                vehicles.add(vehicle);
            } else {
                vehicle = new Vehicle("Truck", model, color, horsepower);
                vehicles.add(vehicle);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"Close the Catalogue".equals(input)) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(input)) {
                    System.out.println(vehicle);
                    break;
                }

            }
            input = scanner.nextLine();
        }
        double carHP = printHorsePower(vehicles, "Car");
        System.out.printf("Cars have average horsepower of: %.2f.%n",carHP);
        double truckHP = printHorsePower(vehicles, "Truck");
        System.out.printf("Trucks have average horsepower of: %.2f.%n",truckHP);

    }

    public static double printHorsePower(ArrayList<Vehicle> vehicles, String type) {
        double sum = 0;
        int counter = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                sum += vehicle.getHorsepower();
                counter++;
            }
        }
        if (counter == 0) {
            return 0;
        }
        return sum / counter;
    }
}
