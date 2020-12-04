import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input;

        while (!"stop".equals(input = scanner.nextLine())) {
            int quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input) + quantity);
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
