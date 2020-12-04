import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> length = (a, b) -> a.length() - b == 0;

        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            switch (tokens[1]) {
                case "StartsWith":
                    startsOrEndsWith(people, tokens[2], tokens[0], startsWith);
                    break;
                case "EndsWith":
                    startsOrEndsWith(people, tokens[2], tokens[0], endsWith);
                    break;
                case "Length":
                    length(people, Integer.parseInt(tokens[2]), tokens[0], length);
                    break;
            }
        }
        Collections.sort(people);
        if (people.size() > 0) {
            System.out.printf("%s are going to the party!", String.join(", ", people));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static List<String> length(List<String> people, int length, String addOrRemove,
                                       BiPredicate<String, Integer> predicate) {
        if (addOrRemove.equals("Double")) {
            people.addAll(people.stream()
                    .filter(e -> predicate.test(e, length))
                    .collect(Collectors.toList()));
            return people;
        } else {
            people.removeAll(people.stream()
                    .filter(e -> predicate.test(e, length))
                    .collect(Collectors.toList()));
            return people;
        }
    }

    public static List<String> startsOrEndsWith(List<String> people, String testingString, String addOrRemove,
                                                BiPredicate<String, String> predicate) {
        if (addOrRemove.equals("Double")) {
            people.addAll(people.stream()
                    .filter(e -> predicate.test(e, testingString))
                    .collect(Collectors.toList()));
            return people;
        } else {

            people.removeAll(people.stream()
                    .filter(e -> predicate.test(e, testingString))
                    .collect(Collectors.toList()));
            return people;
        }
    }
}

