package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car = new Car();

            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsepower(Integer.parseInt(tokens[2]));

            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
