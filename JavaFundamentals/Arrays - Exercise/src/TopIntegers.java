import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayString = scanner.nextLine().split(" ");

        int[] array = new int[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            array[i] = Integer.parseInt(arrayString[i]);
        }
        for (int i = 0; i < array.length; i++) {
            boolean isSmaller = false;
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] <= array[j + 1]) {
                    isSmaller = true;
                    break;
                }
            }
            if (!isSmaller) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
