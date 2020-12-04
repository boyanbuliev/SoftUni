import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);
        int num2 = Integer.parseInt(scanner.nextLine());
        int result = 0;

        switch (operation) {
            case '/':
                result = divide(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
        }
        System.out.println(result);
    }

    private static int subtract(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    private static int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    private static int multiply(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    private static int divide(int num1, int num2) {
        int result = num1 / num2;
        return result;
    }
}
