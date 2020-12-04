import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> people = new HashMap<>();

        String input;

        while (!"search".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("-");
            people.put(tokens[0], tokens[1]);
        }
        while (!"stop".equals(input = scanner.nextLine())) {
            if (people.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, people.get(input));
            }else {
                System.out.printf("Contact %s does not exist.%n",input);
            }
        }
    }
}
