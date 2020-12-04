import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = multiply(num);
        System.out.println(result);
    }

    private static int multiply(int num) {
        int evenSum = sumEvenDigits(num);
        int oddSum = sumOddDigits(num);
        return evenSum * oddSum;
    }

    private static int sumEvenDigits(int num) {
        int oddSum = 0;
        while (num > 0) {
            int currentNum = num % 10;
            num /= 10;
            if (currentNum % 2 == 0) {
                oddSum += currentNum;
            }
        }
        return oddSum;
    }

    private static int sumOddDigits(int num) {
        int evenSum = 0;
        while (num > 0) {
            int currentNum = num % 10;
            num /= 10;
            if (currentNum % 2 != 0) {
                evenSum += currentNum;
            }
        }
        return evenSum;
    }
}