import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        String numbers = "";
        int counter = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            String currentNumbers = "";
            int currentCounter = 0;
            for (int j = i; j >= 0; j--) {
                if (array[i] == array[j]) {
                    currentNumbers += String.valueOf(array[i] + " ");
                    currentCounter++;
                } else {
                    break;
                }
            }
            if (currentCounter >= counter) {
                counter = currentCounter;
                numbers = currentNumbers;
            }
        }
        System.out.println(numbers);
    }
}
