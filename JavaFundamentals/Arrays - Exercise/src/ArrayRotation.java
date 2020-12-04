import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tempArray = new String[array.length];
            for (int j = 0; j < array.length - 1; j++) {
                tempArray[j] = array[j + 1];
            }
            tempArray[array.length - 1] = array[0];
            array = tempArray;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("testing");
    }
}

