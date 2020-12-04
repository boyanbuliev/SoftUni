import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                digits.append(input.charAt(i));
            } else if (input.charAt(i) >= 65 && input.charAt(i) <= 90 ||
                    input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                letters.append(input.charAt(i));
            } else {
                other.append(input.charAt(i));
            }
        }
        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(other.toString());
    }
}
