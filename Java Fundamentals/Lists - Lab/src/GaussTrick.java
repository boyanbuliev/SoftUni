import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < input.size() / 2; i++) {
            printSum(input.get(i), input.get(input.size() - 1 - i));
        }
        if (input.size() % 2 != 0) {
            System.out.print(input.get(input.size() / 2));
        }
    }

    public static void printSum(int num1, int num2) {
        System.out.print(num1 + num2 + " ");
    }
}
