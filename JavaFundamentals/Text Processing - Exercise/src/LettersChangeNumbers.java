import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0.0;

        String alphabet = "0abcdefghijklmnopqrstuvwxyz";

        for (String s : input) {
            char firstLetter = s.charAt(0);
            int firstLetterLocation = alphabet.indexOf(Character.toLowerCase(firstLetter));
            char lastLetter = s.charAt(s.length() - 1);
            int lastLetterLocation = alphabet.indexOf(Character.toLowerCase(lastLetter));
            double number = Integer.parseInt(s.substring(1, s.length() - 1));
            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetterLocation;
            } else {
                number *= firstLetterLocation;
            }
            if (Character.isUpperCase(lastLetter)) {
                number -= lastLetterLocation;
            } else {
                number += lastLetterLocation;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
