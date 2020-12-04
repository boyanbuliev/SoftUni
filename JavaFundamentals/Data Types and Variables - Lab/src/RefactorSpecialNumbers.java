import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            int currentNum = i;
            int result = 0;

            while (currentNum > 0) {
                result += currentNum % 10;
                currentNum = currentNum / 10;
            }
            boolean isSpecial = (result == 5) || (result == 7) || (result == 11);

            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            }else {
                System.out.printf("%d -> False%n",i);
            }
        }
    }
}