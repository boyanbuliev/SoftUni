import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberAsString = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();

        int remainder = 0;

        while (numberAsString.charAt(0) == '0' && numberAsString.length() > 1) {
            numberAsString = numberAsString.substring(1);
        }

        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            int product = digit * multiplier + remainder;
            result.append(product % 10);
            remainder = product / 10;
        }
        if (remainder > 0) {
            result.append(remainder);
        }
        if (multiplier != 0) {
            System.out.println(result.reverse());
        } else {
            System.out.println(0);
        }
    }
}
