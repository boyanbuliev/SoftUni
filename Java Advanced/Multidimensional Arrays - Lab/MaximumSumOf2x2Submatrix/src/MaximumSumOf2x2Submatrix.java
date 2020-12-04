import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = getInput(scanner);

        int[][] matrix = getMatrix(input[0], input[1], scanner);

        int biggestSum = Integer.MIN_VALUE;

        int row = -1;
        int col = -1;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum > biggestSum) {
                    biggestSum = sum;
                    row = r;
                    col = c;
                }
            }
        }
        System.out.printf("%d %d%n%d %d%n%d",
                matrix[row][col], matrix[row][col + 1], matrix[row + 1][col],
                matrix[row + 1][col + 1], biggestSum);
    }


    private static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = getInput(scanner);
        }
        return matrix;
    }

    public static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("[\\s+,]+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
