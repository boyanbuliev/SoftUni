package PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();


        String input;

        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String trainer = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon currentPokemon = new Pokemon(pokemon, element, health);
            trainers.putIfAbsent(trainer, new Trainer(trainer, new ArrayList<>()));
            trainers.get(trainer).getPokemon().add(currentPokemon);
        }
        while (!"End".equals(input = scanner.nextLine())) {

            for (Trainer trainer : trainers.values()) {
                if (trainer.isContained(input)) {
                    trainer.setBadge(trainer.getBadge() + 1);
                } else {
                    trainer.loseHealth();
                }
            }
        }
        trainers.values()
                .stream()
                .sorted((t1, t2) -> t2.getBadge() - t1.getBadge())
                .forEach(System.out::println);
    }
}
