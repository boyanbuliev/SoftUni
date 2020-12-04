import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChar = scanner.nextLine().charAt(0);
        char endChar = scanner.nextLine().charAt(0);

        printCharsBetween(startChar, endChar);
    }

    private static void printCharsBetween(char startChar, char endChar) {
        if (startChar < endChar) {
            for (int i = startChar + 1; i < endChar; i++) {
                System.out.print((char)i + " ");
            }
        } else {
            for (int i = endChar + 1; i < startChar; i++) {
                System.out.print((char)i + " ");
            }
        }
    }
}