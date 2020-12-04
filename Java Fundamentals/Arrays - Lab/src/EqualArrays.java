import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1String = scanner.nextLine().split(" ");
        String[] array2String = scanner.nextLine().split(" ");

        int[] array1 = new int[array1String.length];
        int[] array2 = new int[array2String.length];

        boolean isDifferent = false;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < array1String.length; i++) {
            array1[i] = Integer.parseInt(array1String[i]);
            array2[i] = Integer.parseInt(array2String[i]);
            index = i;
            sum += array1[i];
            if (array1[i] != array2[i]) {
                isDifferent = true;
                break;
            }
        }
        if (!isDifferent) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }

    }
}

