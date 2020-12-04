import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        matrixCreator(n);
    }

    private static void matrixCreator(int n) {
        for (int i = 0; i < n; i++) {
            rowWriting(n);
            System.out.println();
        }


    }

    private static void rowWriting(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }
    }
}
