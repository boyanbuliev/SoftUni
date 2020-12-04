import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", 1.0 * m / 1000);
    }
}
