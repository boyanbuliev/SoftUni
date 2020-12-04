import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayString = scanner.nextLine().split(" ");

        int[] array = new int[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            array[i] = Integer.parseInt(arrayString[i]);
        }
        int leftSum = 0;
        boolean flag = false;

        for (int i = 0; i < array.length ; i++) {
            int rightSum = 0;
            for (int j = array.length - 1; j > i; j--) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                flag = true;
            }
            leftSum += array[i];
        }
        if (!flag) {
            System.out.println("no");
        }
    }
}
