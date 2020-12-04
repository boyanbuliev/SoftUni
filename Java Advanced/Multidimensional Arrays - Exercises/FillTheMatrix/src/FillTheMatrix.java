import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);

        int[][] matrix = new int[rows][rows];

        if (input[1].equals("A")) {
            matrix = patternA(rows);
        } else {
            matrix = patternB(rows);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(Arrays.toString(matrix[r]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static int[][] patternB(int rows) {
        int[][] matrix = new int[rows][rows];
        int currentNum = 1;
        for (int c = 0; c < rows; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < rows; r++) {
                    matrix[r][c] = currentNum++;
                }
            } else {
                for (int r = rows - 1; r >= 0; r--) {
                    matrix[r][c] = currentNum++;
                }
            }
        }

        return matrix;
    }

    private static int[][] patternA(int rows) {
        int[][] matrix = new int[rows][rows];
        int currentNum = 1;
        for (int c = 0; c < rows; c++) {
            for (int r = 0; r < rows; r++) {
                matrix[r][c] = currentNum++;
            }
        }

        return matrix;
    }
}
