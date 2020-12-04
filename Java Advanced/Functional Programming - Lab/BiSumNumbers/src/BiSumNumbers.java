import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class BiSumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        BiFunction<Integer, Integer, Integer> parser = Integer::sum;

        for (int number : input) {
            sum = parser.apply(sum, number);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
