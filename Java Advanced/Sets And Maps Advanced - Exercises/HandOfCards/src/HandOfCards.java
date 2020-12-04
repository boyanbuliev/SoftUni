import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        String input;

        while (!"JOKER".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(":\\s+");
            String[] cards = tokens[1].split(", ");
            players.putIfAbsent(tokens[0], new HashSet<>());
            players.get(tokens[0]).addAll(Arrays.asList(cards));
        }
        players.forEach((key, value) -> System.out.printf("%s: %d%n", key, getSum(value)));

    }

    private static int getSum(HashSet<String> value) {
        int sum = 0;
        for (String s : value) {
            sum += findColor(s.substring(s.length() - 1)) * findCard(s.substring(0, s.length() - 1));
        }
        return sum;
    }

    private static int findCard(String card) {
        switch (card) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(card);
        }
    }

    private static int findColor(String color) {
        switch (color) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
            default:
                return 0;
        }

    }


}
