import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            symbols.putIfAbsent(input.charAt(i), 0);
            symbols.put(input.charAt(i), symbols.get(input.charAt(i)) + 1);
        }
        symbols.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));

    }
}
