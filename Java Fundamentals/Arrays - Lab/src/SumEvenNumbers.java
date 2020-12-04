import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbersAsString = scanner.nextLine();
        String[] stringArray = numbersAsString.split(" ");

        int sum = 0;

        int[] numbers = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            numbers[i] = Integer.parseInt(stringArray[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
