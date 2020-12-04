import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nString = scanner.nextLine();
        int n = Integer.parseInt(nString);
        int sum = 0;
        int currentdigit = n;

        while (currentdigit > 0) {
            sum += currentdigit % 10;
            currentdigit /= 10;
        }
        System.out.println(sum);
    }
}
