import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] letters = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = w -> Character.isUpperCase(w.charAt(0));

        System.out.println(Arrays
                .stream(letters)
                .filter(predicate)
                .count());

        Arrays.stream(letters).filter(predicate).forEach(System.out::println);
    }
}
