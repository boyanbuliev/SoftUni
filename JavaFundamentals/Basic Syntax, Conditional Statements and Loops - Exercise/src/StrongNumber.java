import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);


        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentSum = 1;
            int digit = Integer.parseInt("" + input.charAt(i));
            for (int j = 1; j <= digit; j++) {
                currentSum *= j;
            }
            sum += currentSum;
        }
        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
