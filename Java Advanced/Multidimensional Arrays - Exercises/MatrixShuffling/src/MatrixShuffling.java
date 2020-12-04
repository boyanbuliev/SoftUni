import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = getInput(scanner);

        String[][] matrix = new String[input[0]][input[1]];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        String command = "";
        while (!(command = scanner.nextLine()).equals("END")) {
            String[] tokens = command.split("\\s+");
            if (!tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }
            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (row1 < 0 || row1 >= matrix.length || col1 < 0 || col1 >= matrix[0].length ||
                    row2 < 0 || row2 >= matrix.length || col2 < 0 || col2 >= matrix[0].length) {
                System.out.println("Invalid input!");
                continue;
            }
            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
            printMatrix(matrix);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", ""));
        }
    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
