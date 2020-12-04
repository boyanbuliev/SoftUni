import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Double>> map = new LinkedHashMap<>();

        while (!"buy".equals(input)) {
            String[] tokens = input.split("\\s+");
            String drink = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);
            map.putIfAbsent(drink, Arrays.asList(0.0, 0.0));

            map.put(drink, Arrays.asList(price, (map.get(drink).get(1) + quantity)));

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(),
                    entry.getValue().get(0) * entry.getValue().get(1));
        }

    }
}
