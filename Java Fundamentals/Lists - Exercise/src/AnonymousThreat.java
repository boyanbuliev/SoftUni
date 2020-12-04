import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] commandArr = command.split("\\s+");
            switch (commandArr[0]) {
                case "merge":
                    int startIndex = Math.max(0, Integer.parseInt(commandArr[1]));
                    int endIndex = Math.min(input.size() - 1, Integer.parseInt(commandArr[2]));
                    for (int i = endIndex - 1; i >= startIndex; i--) {
                        input.set(i, input.get(i) + input.get(i + 1));
                        input.remove(i + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commandArr[1]);
                    int partitions = Integer.parseInt(commandArr[2]);
                    int elementSize = input.get(index).length() / partitions;
                    String[] tokens = new String[partitions];
                    List<String> item = Arrays.stream(input.get(index).split(""))
                            .collect(Collectors.toList());
                    for (int i = 0; i < partitions; i++) {
                        for (int j = elementSize - 1; j > 0; j--) {
                            item.set(j - 1, item.get(j - 1) + item.get(j));
                            item.remove(j);
                        }
                        tokens[i] = item.get(0);
                        item.remove(0);
                    }
                    while (item.size() > 0) {
                        tokens[partitions - 1] += item.get(0);
                        item.remove(0);
                    }
                    input.remove(index);
                    input.addAll(index, Arrays.asList(tokens));
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", input));
    }
}
