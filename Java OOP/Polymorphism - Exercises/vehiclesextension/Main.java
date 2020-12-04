package vehiclesextension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]),
                Double.parseDouble(input[3]));
        input = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]),
                Double.parseDouble(input[3]));
        input = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(input[1]), Double.parseDouble(input[2]),
                Double.parseDouble(input[3]));

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[1].equals("Car")) {
                fulfillAction(car, tokens);
            } else if (tokens[1].equals("Truck")) {
                fulfillAction(truck, tokens);
            } else {
                fulfillAction(bus, tokens);
            }
        }
        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f%n",
                car.getFuelQuantity(), truck.getFuelQuantity(), bus.getFuelQuantity());
    }

    private static void fulfillAction(Vehicle vehicle, String[] tokens) {
        double value = Double.parseDouble(tokens[2]);
        if (tokens[0].equals("Drive")) {
            if (vehicle instanceof Bus) {
                System.out.println(((Bus) vehicle).drive(value));
            } else {
                System.out.println(vehicle.drive(value));
            }
        } else if (tokens[0].equals("DriveEmpty")) {
            System.out.println(vehicle.drive(value));
        } else
            try {
                vehicle.refuel(value);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
    }
}

