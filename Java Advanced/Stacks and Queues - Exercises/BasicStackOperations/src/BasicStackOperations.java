import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();


        for (int i = 0; i < commands[0]; i++) {
            numbers.push(input[i]);
        }
        for (int i = 0; i < commands[1]; i++) {
            numbers.pop();
        }
        if (numbers.contains(commands[2])) {
            System.out.println("true");
        } else {
            if (!numbers.isEmpty()) {
                int minNumber = Integer.MAX_VALUE;
                for (Integer number : numbers) {
                    if (minNumber > number) {
                        minNumber=number;
                    }
                }
                System.out.println(minNumber);
            } else {
                System.out.println(0);
            }
        }
    }
}
