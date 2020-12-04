import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestElement = a -> {
            int min = a.stream().min(Integer::compareTo).orElse(-1);
            return a.lastIndexOf(min);
//            int index = -1;
//            int smallestNum = Integer.MAX_VALUE;
//            for (int i = 0; i < a.size(); i++) {
//                if (smallestNum >= a.get(i)) {
//                    index = i;
//                    smallestNum = a.get(i);
//                }
//            }
//            return index;
        };
        System.out.println(smallestElement.apply(numbers));
    }
}
