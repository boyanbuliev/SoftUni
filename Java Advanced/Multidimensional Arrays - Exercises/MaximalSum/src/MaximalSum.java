import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = getInput(scanner);

        int[][] matrix = new int[input[0]][input[1]];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = getInput(scanner);
        }

        int maxSum = Integer.MIN_VALUE;

        int[] startIndex = new int[2];

        int row = 0;
        int col = 0;

        while (row < matrix.length - 2) {
            while (col < matrix[row].length - 2) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = new int[]{row, col};
                }
                col++;
            }
            col = 0;
            row++;
        }
        System.out.println("Sum = "+maxSum);
        for (int r = startIndex[0]; r < startIndex[0] + 3; r++) {
            System.out.printf("%d %d %d%n", matrix[r][startIndex[1]], matrix[r][startIndex[1] + 1], matrix[r][startIndex[1] + 2]);

        }
    }


    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
