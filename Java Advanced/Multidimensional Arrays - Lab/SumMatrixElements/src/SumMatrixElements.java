import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = getInput(scanner);

        int[][] matrix = getMatrix(input[0], input[1], scanner);
        System.out.println(input[0]);
        System.out.println(input[1]);
        System.out.println(getResult(matrix));
    }

    private static int getResult(int[][] matrix) {
        int result = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                result += matrix[r][c];
            }

        }
        return result;
    }

    private static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = getInput(scanner);
        }

        return matrix;
    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("[\\s+,]+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
