import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = Double.parseDouble(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(result(num1, num2)));
    }

    private static double result(double num1, int num2) {
        return Math.pow(num1, num2);
    }
}
