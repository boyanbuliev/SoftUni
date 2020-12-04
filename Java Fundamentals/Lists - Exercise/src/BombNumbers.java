import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] bombArr = scanner.nextLine().split("\\s+");
        int[] bomb = new int[bombArr.length];
        for (int i = 0; i < bomb.length; i++) {
            bomb[i] = Integer.parseInt(bombArr[i]);
        }
        while (numbers.contains(bomb[0])) {
            int bombIndex = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(bomb[0])) {
                    bombIndex = i;
                    int startingNumber = bombIndex - bomb[1];
                    if (startingNumber <0) {
                        startingNumber = 0;
                    }
                    for (int j = 0; j < bomb[1] * 2 + 1; j++) {
                        if (startingNumber < numbers.size()) {
                            numbers.remove(startingNumber);
                        } else {
                            break;
                        }
                        i = -1;
                    }
                }
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
