import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            String[] currentArray = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                array1[i] = Integer.parseInt(currentArray[0]);
                array2[i] = Integer.parseInt(currentArray[1]);
            }
            if (i % 2 != 0) {
                array1[i] = Integer.parseInt(currentArray[1]);
                array2[i] = Integer.parseInt(currentArray[0]);
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
    }
}
