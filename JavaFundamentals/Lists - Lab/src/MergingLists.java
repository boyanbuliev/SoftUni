import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = readList(scanner);
        List<Integer> list2 = readList(scanner);

        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < list1.size() && i < list2.size()) {
            result.add(list1.get(i));
            result.add(list2.get(i));
            i++;
        }
        if (i < list1.size()) {
            result.addAll(getLeftovers(list1, i));
        } else if (i < list2.size()) {
            result.addAll(getLeftovers(list2, i));
        }

        for (int number : result) {
            System.out.print(number + " ");
        }

    }

    private static List<Integer> getLeftovers(List<Integer> list1, int i) {
        List<Integer> result = new ArrayList<>();
        for (int j = i; j < list1.size(); j++) {
            result.add(list1.get(j));
        }
        return result;
    }

    public static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
