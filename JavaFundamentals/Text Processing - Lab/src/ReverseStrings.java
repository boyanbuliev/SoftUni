import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String reversedInput = "";
            for (int j = input.length() - 1; j >= 0; j--) {
                reversedInput += input.charAt(j);
            }
            System.out.println(input + " = " + reversedInput);
            input = scanner.nextLine();
        }
    }
}
