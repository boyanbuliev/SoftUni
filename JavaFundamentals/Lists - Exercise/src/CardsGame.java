import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = readList(scanner);
        List<Integer> secondHand = readList(scanner);

        while (firstHand.size() > 0 && secondHand.size() > 0) {
            if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add(firstHand.get(0));
                firstHand.remove(0);
                firstHand.add(secondHand.get(0));
                secondHand.remove(secondHand.get(0));
            } else if (secondHand.get(0) > firstHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.remove(0);
                secondHand.add(firstHand.get(0));
                firstHand.remove(firstHand.get(0));
            } else {
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }
        if (firstHand.size() > 0) {
            printSum(firstHand, "First");
        } else {
            printSum(secondHand, "Second");
        }


    }

    public static void printSum(List<Integer> winningHand, String player) {
        int sum = 0;
        for (Integer card : winningHand) {
            sum += card;
        }
        System.out.printf("%s player wins! Sum: %d", player, sum);
    }

    public static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
