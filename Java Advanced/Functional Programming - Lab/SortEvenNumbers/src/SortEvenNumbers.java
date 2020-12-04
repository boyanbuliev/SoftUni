import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .toArray();

        printArray(numbers);

        Arrays.sort(numbers);

        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        System.out.println(Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
    }
}
