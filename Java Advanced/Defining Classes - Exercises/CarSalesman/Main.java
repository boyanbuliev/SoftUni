package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engineMap = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        while (n-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;

            if (tokens.length == 4) {
                engine = new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]);
            } else if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else {
                try {
                    engine = new Engine(model, power, Integer.parseInt(tokens[2]));
                } catch (NumberFormatException e) {
                    engine = new Engine(model, power, tokens[2]);
                }
            }
            engineMap.put(model, engine);
        }

        n = Integer.parseInt(bufferedReader.readLine());
        while (n-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];
            Car car;
            if (tokens.length == 4) {
                car = new Car(model, engineMap.get(engine), Integer.parseInt(tokens[2]), tokens[3]);
            } else if (tokens.length == 2) {
                car = new Car(model, engineMap.get(engine));
            } else {
                try {
                    car = new Car(model, engineMap.get(engine), Integer.parseInt(tokens[2]));
                } catch (NumberFormatException e) {
                    car = new Car(model, engineMap.get(engine), tokens[2]);
                }
            }
            cars.add(car);
        }

        cars.forEach(System.out::println);

    }
}

