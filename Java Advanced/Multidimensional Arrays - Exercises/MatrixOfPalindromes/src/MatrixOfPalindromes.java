import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[input[0]][input[1]];

        char currentChar = 'a';
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char middleChar = (char) (currentChar + c);
                matrix[r][c] = "" + currentChar + middleChar + currentChar;
            }
            currentChar = (char) (currentChar + 1);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(String.join(" ", matrix[r]));

        }
    }
}
