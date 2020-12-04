import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulatingBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    numbers.remove((Object) Integer.parseInt(command[1]));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
