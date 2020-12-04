import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> users = new LinkedHashMap<>();

        String input;

        while (!"stop".equals(input = scanner.nextLine())) {
            String email = scanner.nextLine();
            users.put(input, email);
        }
        users.entrySet()
                .stream()
                .filter(e -> !e.getValue().toLowerCase().endsWith("us") &&
                        !e.getValue().toLowerCase().endsWith("uk") &&
                        !e.getValue().toLowerCase().endsWith("com"))
                .forEach(e -> System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));
    }
}
