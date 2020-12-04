import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            int currentnum = 1;
            for (int j = 0; j < i; j++) {
                System.out.print(currentnum + " ");
                currentnum++;
            }
            System.out.println();
        }
        for (int i = input; i > 0; i--) {
            int currentnum = 1;
            for (int j = i-1; j > 0; j--) {
                System.out.print(currentnum + " ");
                currentnum++;
            }
            System.out.println();
        }
    }
}
