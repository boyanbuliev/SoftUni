package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new HashMap<>();

        String input;

        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String action = tokens[1];

            switch (action) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    persons.putIfAbsent(name, new Person(name));
                    persons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    persons.putIfAbsent(name, new Person(name));
                    persons.get(name).setPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    persons.putIfAbsent(name, new Person(name));
                    persons.get(name).setParent(parent);
                    break;
                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    persons.putIfAbsent(name, new Person(name));
                    persons.get(name).setChild(child);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    persons.putIfAbsent(name, new Person(name));
                    persons.get(name).setCar(car);
                    break;
            }
        }

        input = scanner.nextLine();

        System.out.println(persons.get(input).toString());
    }
}
