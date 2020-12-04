package WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input;
        List<Mammal> animals = new ArrayList<>();

        while (!"End".equals(input = bf.readLine())) {
            String[] animal = input.split("\\s+");
            String[] food = bf.readLine().split("\\s+");


            switch (animal[0]) {
                case "Cat":
                    Cat cat = new Cat(animal[0], animal[1], Double.parseDouble(animal[2]),
                            animal[3], animal[4]);
                    cat.makeSound();
                    eatFood(cat, food);
                    animals.add(cat);
                    System.out.println(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    tiger.makeSound();
                    eatFood(tiger, food);
                    animals.add(tiger);
                    System.out.println(tiger);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    zebra.makeSound();
                    eatFood(zebra, food);
                    animals.add(zebra);
                    System.out.println(zebra);
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    mouse.makeSound();
                    eatFood(mouse, food);
                    animals.add(mouse);
                    System.out.println(mouse);
                    break;
            }
        }
//        for (Mammal animal : animals) {
//            System.out.println(animal);
//        }
    }

    private static void eatFood(Animal animal, String[] food) {
        try {
            if (food[0].equals("Vegetable")) {
                animal.eat(new Vegetable(Integer.parseInt(food[1])));
            } else {
                animal.eat(new Meat(Integer.parseInt(food[1])));
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
