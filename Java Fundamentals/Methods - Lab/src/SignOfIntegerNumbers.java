import java.util.Scanner;

public class SignOfIntegerNumbers {

    public static void printSign(int num) {
        if (num > 0) {
            System.out.println("The number " + num + " is positive.");
        } else if (num < 0) {
            System.out.println("The number " + num + " is negative.");
        } else {
            System.out.println("The number " + num + " is zero.");
        }
    }

    public static void printSignFormat(int num) {
        String format = "The number %d is zero.";
        if (num > 0) {
            format = "The number %d is positive.";
        } else if (num < 0) {
            format = "The number %d is negative.";
        }
        System.out.printf(format, num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        printSignFormat(number);
    }
}
