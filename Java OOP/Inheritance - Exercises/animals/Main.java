package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();
        String input;

        while (!"Beast!".equals(input = bf.readLine())) {
            String[] data = bf.readLine().split(" ");
            try {
                Animal animal = createAnimal(input, data);
                animals.add(animal);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        animals.forEach(System.out::println);
    }

    private static Animal createAnimal(String input, String[] data) {
        switch (input) {
            case "Cat":
                return new Cat(data[0], Integer.parseInt(data[1]), data[2]);
            case "Dog":
                return new Dog(data[0], Integer.parseInt(data[1]), data[2]);
            case "Frog":
                return new Frog(data[0], Integer.parseInt(data[1]), data[2]);
            case "Kitten":
                return new Kitten(data[0], Integer.parseInt(data[1]));
            case "Tomcat":
                return new Tomcat(data[0], Integer.parseInt(data[1]));
            default:
                throw new IllegalStateException("Invalid input!");
        }
    }
}
