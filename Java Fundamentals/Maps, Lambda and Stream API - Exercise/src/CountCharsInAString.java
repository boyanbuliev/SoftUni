import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < words.length(); i++) {
            if (!(words.charAt(i) + "").equals(" ")) {
                chars.putIfAbsent(words.charAt(i), 0);
                chars.put(words.charAt(i), chars.get(words.charAt(i)) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
