import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isCharValid = passwordCharCountValidator(input);
        boolean isLettersValid = passwordLettersDigitsValidator(input);
        boolean isDigitValid = passwordDigitCountValidator(input);

        if (isCharValid && isDigitValid
                && isLettersValid) {
            System.out.println("Password is valid");
        }

    }

    private static boolean passwordDigitCountValidator(String input) {
        int digitCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                digitCounter++;
            }
        }
        if (digitCounter >= 2) {
            return true;
        } else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }

    private static boolean passwordLettersDigitsValidator(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 122) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean passwordCharCountValidator(String input) {
        if (input.length() < 6 || input.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }
}
