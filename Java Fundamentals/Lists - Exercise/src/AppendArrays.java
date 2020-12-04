import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(input);

        List<String> finishedList = new ArrayList<>();

        for (String item : input) {
            List<String> currentPosition = Arrays.stream(item.split("\\s+"))
                    .collect(Collectors.toList());
            currentPosition.removeIf(String::isEmpty);
            finishedList.addAll(currentPosition);
        }
        System.out.println(String.join(" ", finishedList));
    }
}

