import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(n, scanner);

        int diagonal1 = countDiagonal1(matrix);
        int diagonal2 = countDiagonal2(matrix);

        System.out.println(Math.abs(diagonal1 - diagonal2));

    }


//    private static int countDiagonal2(int[][] matrix) {
//        int diagonal = 0;
//        int counter = matrix[0].length - 1;
//        for (int r = 0; r < matrix.length; r++) {
//            diagonal += matrix[r][counter--];
//        }
//        return diagonal;
//    }

    private static int countDiagonal2(int[][] matrix) {
        int diagonal = 0;
        int counter = 0;
        for (int c = matrix.length - 1; c >= 0; c--) {
            diagonal += matrix[counter++][c];
        }
        return diagonal;
    }

    private static int countDiagonal1(int[][] matrix) {
        int diagonal = 0;

        for (int r = 0; r < matrix.length; r++) {
            diagonal += matrix[r][r];
        }
        return diagonal;
    }

    private static int[][] readMatrix(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
