import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = getInput(scanner);
        int[][] matrix1 = matrixUpdater(input[0], input[1], scanner);

        input = getInput(scanner);
        int[][] matrix2 = matrixUpdater(input[0], input[1], scanner);

        boolean isEqual = matrixComparator(matrix1, matrix2);
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matrixComparator(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int r = 0; r < matrix1.length; r++) {
            for (int c = 0; c < matrix1[r].length; c++) {
                if (matrix1[r][c] != matrix2[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] matrixUpdater(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            int[] tokens = getInput(scanner);
            for (int c = 0; c < columns; c++) {
                matrix[r][c] = tokens[c];

            }
        }
        return matrix;
    }
}
