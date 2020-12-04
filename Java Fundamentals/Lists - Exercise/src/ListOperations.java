import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<>
                (Arrays.asList(scanner.nextLine().split("\\s+")));

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    numbers.add(tokens[1]);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(tokens[2]);
                    if (insertIndex < numbers.size() && insertIndex >= 0) {
                        numbers.add(insertIndex, tokens[1]);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    if (removeIndex < numbers.size() && removeIndex >= 0) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int rotations = Integer.parseInt(tokens[2]);
                    if (tokens[1].equals("left")) {
                        for (int i = 0; i < rotations % numbers.size(); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else {
                        for (int i = 0; i < rotations % numbers.size(); i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
}
