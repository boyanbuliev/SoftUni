import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(palindromeChecker(input));
            input = scanner.nextLine();
        }
    }

    private static String palindromeChecker(String input) {
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return "true";
        } else {
            return "false";
        }
    }
}
