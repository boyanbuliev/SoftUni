import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = getMatrix(rows, scanner);
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                newMatrix[r][c] = matrix[r][c];
            }
        }
        int[] wrongValues = getInput(scanner);
        int wrongValue = matrix[wrongValues[0]][wrongValues[1]];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int currentValue = 0;
                    if (r > 0) {
                        if (matrix[r - 1][c] != wrongValue) {
                            currentValue += matrix[r - 1][c];
                        }
                    }
                    if (r < matrix.length - 1) {
                        if (matrix[r + 1][c] != wrongValue) {
                            currentValue += matrix[r + 1][c];
                        }
                    }
                    if (c > 0) {
                        if (matrix[r][c - 1] != wrongValue) {
                            currentValue += matrix[r][c - 1];
                        }
                    }
                    if (c < matrix[r].length - 1) {
                        if (matrix[r][c + 1] != wrongValue) {
                            currentValue += matrix[r][c + 1];
                        }
                    }
                    newMatrix[r][c] = currentValue;
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(Arrays.toString(newMatrix[r]).replaceAll("[\\[\\],]", ""));
        }

    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] getMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < rows; r++) {
            matrix[r] = getInput(scanner);
        }
        return matrix;
    }
}
