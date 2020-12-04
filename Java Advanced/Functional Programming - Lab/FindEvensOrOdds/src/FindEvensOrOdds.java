import java.util.*;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> numbers = new ArrayList<>();


        Map<String, Predicate<Integer>> predicateMap = new LinkedHashMap<>();

        for (int i = range[0]; i <= range[1]; i++) {
            numbers.add(i);
            predicateMap.put("odd", number -> number % 2 != 0);
            predicateMap.put("even", number -> number % 2 == 0);
        }
        String input = scanner.nextLine();

        numbers.stream().filter(predicateMap.get(input)).forEach(e -> System.out.print(e + " "));
    }
}
