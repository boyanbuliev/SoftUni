package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = bf.readLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double cost = Double.parseDouble(tokens[2]);
            cars.put(model, new Car(model, fuel, cost));
        }

        String input;
        while (!"End".equals(input = bf.readLine())) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int km = Integer.parseInt(tokens[2]);

            if (!cars.get(model).drive(km)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        cars.values().forEach(System.out::println);
    }
}
