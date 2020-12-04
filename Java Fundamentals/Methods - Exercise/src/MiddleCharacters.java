import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(getMiddleChar(input));

    }

    private static String getMiddleChar(String input) {
        String middleChar = "";
        if (input.length() % 2 == 0) {
            middleChar = "" + input.charAt(input.length() / 2 - 1) + input.charAt(input.length() / 2);
        } else {
            middleChar = "" + input.charAt(input.length() / 2);
        }
        return middleChar;
    }
}
