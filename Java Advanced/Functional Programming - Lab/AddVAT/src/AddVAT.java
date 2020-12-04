import java.util.Arrays;
import java.util.Scanner;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(str -> Double.parseDouble(str) * 1.2).forEach(e -> System.out.printf("%.2f%n", e));
    }
}
