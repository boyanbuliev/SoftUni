import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String key = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (key.contains(substring)) {
                        System.out.printf("%s contains %s%n", key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip": {
                    String toCase = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String modifiedSubstring = key.substring(startIndex, endIndex);
                    if (toCase.equals("Upper")) {
                        modifiedSubstring = modifiedSubstring.toUpperCase();
                    } else {
                        modifiedSubstring = modifiedSubstring.toLowerCase();
                    }
                    key = key.substring(0, startIndex) + modifiedSubstring + key.substring(endIndex);
                    System.out.println(key);
                    break;
                }
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    key = key.substring(0, startIndex) + key.substring(endIndex);
                    System.out.println(key);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", key);
    }
}
