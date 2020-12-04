import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        while (numbers.length > 1) {
            int[] arrayCondensed = new int[numbers.length - 1];
            for (int i = 0; i < arrayCondensed.length; i++) {
                arrayCondensed[i] = numbers[i] + numbers[i + 1];
            }
            numbers = arrayCondensed;
        }
        System.out.println(numbers[0]);
    }
}
