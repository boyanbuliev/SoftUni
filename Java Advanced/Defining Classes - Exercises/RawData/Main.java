package RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        Cargo cargo;
        Engine engine;
        Tire tire;

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double t1p = Double.parseDouble(tokens[5]);
            int t1a = Integer.parseInt(tokens[6]);
            double t2p = Double.parseDouble(tokens[7]);
            int t2a = Integer.parseInt(tokens[8]);
            double t3p = Double.parseDouble(tokens[9]);
            int t3a = Integer.parseInt(tokens[10]);
            double t4p = Double.parseDouble(tokens[11]);
            int t4a = Integer.parseInt(tokens[12]);
            cargo = new Cargo(weight, type);
            engine = new Engine(speed, power);
            tire = new Tire(t1p, t1a, t2p, t2a, t3p, t3a, t4p, t4a);
            cars.put(model, new Car(model, engine, cargo, tire));
        }

        String input = scanner.nextLine();

        cars.entrySet()
                .forEach(e -> {
                    if ("fragile".equals(input)) {
                        if (e.getValue().getTire().isFragile() && e.getValue().getCargo().getType().equals(input)) {
                            System.out.println(e.getValue().getModel());
                        }
                    } else {
                        if (e.getValue().getCargo().getType().equals(input) && e.getValue().getEngine().getPower() > 250) {
                            System.out.println(e.getValue().getModel());
                        }
                    }


                });

    }
}
