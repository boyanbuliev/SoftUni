import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String username = input[1];
            switch (input[0]) {
                case "register":
                    if (!map.containsKey(username)) {
                        String licencePlate = input[2];
                        map.put(username, licencePlate);
                        System.out.printf("%s registered %s successfully%n", username, licencePlate);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", map.get(username));
                    }
                    break;
                case "unregister":
                    if (!map.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        map.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }

        map.entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s => %s%n", e.getKey(), e.getValue()));
    }
}
