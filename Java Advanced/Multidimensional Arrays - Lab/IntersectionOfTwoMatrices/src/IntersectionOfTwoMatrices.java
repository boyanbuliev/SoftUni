import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = getMatrix(rows, cols, scanner);
        char[][] matrix2 = getMatrix(rows, cols, scanner);

        char[][] matrix3 = matrixCompare(matrix1, matrix2, rows, cols);

        printMatrix(matrix3);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(String.join(" ",
                    Arrays.toString(matrix[r])).replaceAll("[\\[\\],]", ""));
        }
    }

    private static char[][] matrixCompare(char[][] matrix1, char[][] matrix2, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix1[r][c] == matrix2[r][c]) {
                    matrix[r][c] = matrix1[r][c];
                } else {
                    matrix[r][c] = '*';
                }
            }
        }
        return matrix;
    }

    private static char[][] getMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = input[c].charAt(0);
            }
        }
        return matrix;
    }


}
