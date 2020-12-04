import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int[] snake = new int[2];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    snake[0] = i;
                    snake[1] = j;
                }
            }
        }
        int burrowCount = 0;
        int[][] burrow = new int[2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    burrow[burrowCount][0] = i;
                    burrow[burrowCount][1] = j;
                    burrowCount++;
                }
            }
        }

        int food = 0;
        boolean flag = false;
        while (food < 10 && !flag) {
            String input = scanner.nextLine();
            int[] current = new int[2];
            current[0] = snake[0];
            current[1] = snake[1];
            switch (input) {
                case "up":
                    current[0]--;
                    if (checkIfValidIndex(current, matrix)) {
                        switch (matrix[current[0]][current[1]]) {
                            case '-':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                snake = current;
                                break;
                            case '*':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                food++;
                                snake = current;
                                break;
                            case 'B':
                                if (current[0] == burrow[0][0] && current[1] == burrow[0][1]) {
                                    matrix[burrow[1][0]][burrow[1][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[1];
                                } else {
                                    matrix[burrow[0][0]][burrow[0][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[0];
                                }
                                break;
                        }
                    } else {
                        matrix[snake[0]][snake[1]] = '.';
                        flag = true;
                    }
                    break;
                case "down":
                    current[0]++;
                    if (checkIfValidIndex(current, matrix)) {
                        switch (matrix[current[0]][current[1]]) {
                            case '-':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                snake = current;
                                break;
                            case '*':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                food++;
                                snake = current;
                                break;
                            case 'B':
                                if (current[0] == burrow[0][0] && current[1] == burrow[0][1]) {
                                    matrix[burrow[1][0]][burrow[1][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[1];
                                } else {
                                    matrix[burrow[0][0]][burrow[0][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[0];
                                }
                                break;
                        }
                    } else {
                        matrix[snake[0]][snake[1]] = '.';
                        flag = true;
                    }
                    break;
                case "left":
                    current[1]--;
                    if (checkIfValidIndex(current, matrix)) {
                        switch (matrix[current[0]][current[1]]) {
                            case '-':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                snake = current;
                                break;
                            case '*':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                food++;
                                snake = current;
                                break;
                            case 'B':
                                if (current[0] == burrow[0][0] && current[1] == burrow[0][1]) {
                                    matrix[burrow[1][0]][burrow[1][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[1];
                                } else {
                                    matrix[burrow[0][0]][burrow[0][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[0];
                                }
                                break;
                        }
                    } else {
                        matrix[snake[0]][snake[1]] = '.';
                        flag = true;
                    }
                    break;
                case "right":
                    current[1]++;
                    if (checkIfValidIndex(current, matrix)) {
                        switch (matrix[current[0]][current[1]]) {
                            case '-':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                snake = current;
                                break;
                            case '*':
                                matrix[current[0]][current[1]] = 'S';
                                matrix[snake[0]][snake[1]] = '.';
                                food++;
                                snake = current;
                                break;
                            case 'B':
                                if (current[0] == burrow[0][0] && current[1] == burrow[0][1]) {
                                    matrix[burrow[1][0]][burrow[1][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[1];
                                } else {
                                    matrix[burrow[0][0]][burrow[0][1]] = 'S';
                                    matrix[snake[0]][snake[1]] = '.';
                                    matrix[current[0]][current[1]] = '.';
                                    snake = burrow[0];
                                }
                                break;
                        }
                    } else {
                        matrix[snake[0]][snake[1]] = '.';
                        flag = true;
                    }
                    break;
            }
        }
        if (flag) {
            System.out.println("Game over!");
        }
        if (food == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static boolean checkIfValidIndex(int[] current, char[][] matrix) {
        return current[0] >= 0 && current[0] < matrix.length &&
                current[1] >= 0 && current[1] < matrix[0].length;
    }
}
