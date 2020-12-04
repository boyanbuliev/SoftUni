package orderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<People> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            People person = new People(name, id, age);
            people.add(person);
            input = scanner.nextLine();
        }

        people.stream()
                .sorted(Comparator.comparingInt(People::getAge))
                .forEach(p -> System.out.println(p));
    }
}

