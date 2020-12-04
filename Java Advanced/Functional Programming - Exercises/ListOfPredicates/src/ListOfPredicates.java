import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = IntStream.rangeClosed(1, n).toArray();
        int[] divisible = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
//        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
//        List<Integer> divisible = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toList());
        BiPredicate<Integer, int[]> predicate = (num, div) -> {
            for (Integer integer : div) {
                if (num % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        Arrays.stream(numbers)
                .filter(e -> predicate.test(e, divisible))
                .forEach(i -> System.out.print(i + " "));
    }
}
