import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestNum(num1, num2, num3));
    }

    private static int smallestNum(int num1, int num2, int num3) {
        int minNum = 0;

        if (num1 < num2 && num1 < num3) {
            minNum = num1;
        } else if (num2 < num1 && num2 < num3) {
            minNum = num2;
        } else{
            minNum = num3;
        }
        return minNum;
    }
}
