import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println(calculations(num1, num2, num3));

    }

    private static int calculations(int num1, int num2, int num3) {
        int sum = num1 + num2;
        return subtraction(sum,num3);
    }

    private static int subtraction(int sum, int num3) {
        return sum - num3;

    }
}
