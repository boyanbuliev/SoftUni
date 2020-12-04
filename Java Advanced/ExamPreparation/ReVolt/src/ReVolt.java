import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");

        }
        int[] location = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    location[0] = i;
                    location[1] = j;
                }
            }

        }
        boolean flag = false;
        while (count-- > 0 && !flag) {
            String command = scanner.nextLine();
            switch (command) {
                case "up": {
                    int[] current = new int[location.length];
                    current[0] = location[0];
                    current[1] = location[1];
                    current[0]--;
                    current = checkIfValidIndex(current, matrix);
                    switch (matrix[current[0]][current[1]]) {
                        case "-":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            break;
                        case "F":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            flag = true;
                            break;
                        case "T":
                            continue;
                        case "B":
                            while (matrix[current[0]][current[1]].equals("B")) {
                                current[0]--;
                                checkIfValidIndex(current, matrix);
                            }
                            switch (matrix[current[0]][current[1]]) {
                                case "-":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    break;
                                case "F":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    flag = true;
                                    break;
                                case "T":
                                    continue;
                            }
                    }
                    break;
                }
                case "down": {
                    int[] current = new int[location.length];
                    current[0] = location[0];
                    current[1] = location[1];
                    current[0]++;
                    current = checkIfValidIndex(current, matrix);
                    switch (matrix[current[0]][current[1]]) {
                        case "-":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            break;
                        case "F":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            flag = true;
                            break;
                        case "T":
                            continue;
                        case "B":
                            while (matrix[current[0]][current[1]].equals("B")) {
                                current[0]++;
                                checkIfValidIndex(current, matrix);
                            }
                            switch (matrix[current[0]][current[1]]) {
                                case "-":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    break;
                                case "F":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    flag = true;
                                    break;
                                case "T":
                                    continue;
                            }
                    }
                    break;
                }
                case "left": {
                    int[] current = new int[location.length];
                    current[0] = location[0];
                    current[1] = location[1];
                    current[1]--;
                    current = checkIfValidIndex(current, matrix);
                    switch (matrix[current[0]][current[1]]) {
                        case "-":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            break;
                        case "F":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            flag = true;
                            break;
                        case "T":
                            continue;
                        case "B":
                            while (matrix[current[0]][current[1]].equals("B")) {
                                current[1]--;
                                checkIfValidIndex(current, matrix);
                            }
                            switch (matrix[current[0]][current[1]]) {
                                case "-":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    break;
                                case "F":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    flag = true;
                                    break;
                                case "T":
                                    continue;
                            }
                    }
                    break;
                }
                case "right": {
                    int[] current = new int[location.length];
                    current[0] = location[0];
                    current[1] = location[1];
                    current[1]++;
                    current = checkIfValidIndex(current, matrix);
                    switch (matrix[current[0]][current[1]]) {
                        case "-":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            break;
                        case "F":
                            matrix[current[0]][current[1]] = "f";
                            matrix[location[0]][location[1]] = "-";
                            location = current;
                            flag = true;
                            break;
                        case "T":
                            continue;
                        case "B":
                            while (matrix[current[0]][current[1]].equals("B")) {
                                current[1]++;
                                checkIfValidIndex(current, matrix);
                            }
                            switch (matrix[current[0]][current[1]]) {
                                case "-":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    break;
                                case "F":
                                    matrix[current[0]][current[1]] = "f";
                                    matrix[location[0]][location[1]] = "-";
                                    location = current;
                                    flag = true;
                                    break;
                                case "T":
                                    continue;
                            }
                    }
                }
            }
        }
        if (flag) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        for (String[] strings : matrix) {
            System.out.println(String.join("", strings));
        }
    }


    private static int[] checkIfValidIndex(int[] current, String[][] matrix) {
        if (current[0] < 0) {
            current[0] = matrix.length - 1;
        } else if (current[0] >= matrix.length) {
            current[0] = 0;
        } else if (current[1] < 0) {
            current[1] = matrix[0].length - 1;
        } else if (current[1] >= matrix[0].length) {
            current[1] = 0;
        }
        return current;
    }
}

