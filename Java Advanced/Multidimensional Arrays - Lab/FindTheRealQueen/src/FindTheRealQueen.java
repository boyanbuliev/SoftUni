import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] matrix = getMatrix(scanner);

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (matrix[r][c] == 'q') {
                    boolean    isValid = checkIfValid(matrix, r, c);
                    if (isValid) {
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }

    }

    private static boolean checkIfValid(char[][] matrix, int r, int c) {
        int row = r;
        int col = c;

        while (++col < matrix[row].length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        col = c;
        while (--col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        col = c;
        while (++row < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        row = r;
        while (--row >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        row = r;
        while (++row < matrix.length && ++col < matrix[row].length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        row = r;
        col = c;
        while (++row < matrix.length && --col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        row = r;
        col = c;
        while (--row >= 0 && ++col < matrix[row].length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        row = r;
        col = c;
        while (--row > 0 && --col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static char[][] getMatrix( Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int r = 0; r < 8; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < 8; c++) {
                matrix[r][c] = input[c].charAt(0);
            }
        }
        return matrix;
    }
}
