import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long num1Factorial = numFactorial(num1);
        long num2Factorial = numFactorial(num2);
        System.out.printf("%.2f", 1.0 * num1Factorial / num2Factorial);
    }

    private static long numFactorial(long num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
