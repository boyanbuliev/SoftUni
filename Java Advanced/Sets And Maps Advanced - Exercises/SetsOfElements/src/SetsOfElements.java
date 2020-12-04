import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> n = new LinkedHashSet<>();
        LinkedHashSet<Integer> m = new LinkedHashSet<>();

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        while (input[0]-- > 0) {
            n.add(scanner.nextInt());
        }
        while (input[1]-- > 0) {
            m.add(scanner.nextInt());

        }
        n.retainAll(m);
        n.forEach(e-> System.out.print(e+" "));
    }
}UniqueUsernames