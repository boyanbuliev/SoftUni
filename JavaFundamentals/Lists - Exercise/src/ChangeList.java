import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandArr = command.split("\\s+");
            switch (commandArr[0]) {
                case "Delete":
                    while (numbers.contains(commandArr[1])) {
                        numbers.remove(commandArr[1]);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArr[2]);
                    if (index < numbers.size()) {
                        numbers.add(index, commandArr[1]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
}