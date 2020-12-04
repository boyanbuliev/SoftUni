import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        HashMap<String, List<Integer>> towns = new HashMap<>();

        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|+");
            String town = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2].trim());
            if (towns.containsKey(town)) {
                population += towns.get(town).get(0);
                gold += towns.get(town).get(1);
                towns.put(town, Arrays.asList(population, gold));
            } else {
                towns.put(town, Arrays.asList(population, gold));
            }
            input = scanner.nextLine().trim();
        }
        input = scanner.nextLine().trim();

        while (!"End".equals(input)) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            String town = tokens[1];

            if ("Plunder".equals(command)) {
                int currentPeople = Integer.parseInt(tokens[2]);
                int currentGold = Integer.parseInt(tokens[3]);
                int population = towns.get(town).get(0) - currentPeople;
                int gold = towns.get(town).get(1) - currentGold;
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                        town, currentGold, currentPeople);
                if (population > 0 && gold > 0) {
                    towns.put(town, Arrays.asList(population, gold));
                } else {
                    towns.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }
            } else if ("Prosper".equals(command)) {
                int currentGold = Integer.parseInt(tokens[2]);
                if (currentGold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int population = towns.get(town).get(0);
                    int gold = towns.get(town).get(1) + currentGold;
                    towns.put(town, Arrays.asList(population, gold));
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                            currentGold, town, gold);
                }
            }
            input = scanner.nextLine().trim();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", towns.size());
        towns.entrySet()
                .stream()
                .sorted((t1, t2) -> {
                    if (t2.getValue().get(1) - t1.getValue().get(1) == 0) {
                        return t1.getKey().compareTo(t2.getKey());
                    }
                    return t2.getValue().get(1) - t1.getValue().get(1);
                })
                .forEach(t -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        t.getKey(), t.getValue().get(0), t.getValue().get(1)));
    }
}
