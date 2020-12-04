import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {
            if (input[0].equals("Add")) {
                wagons.add(Integer.parseInt(input[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (Integer.parseInt(input[0]) + wagons.get(i) <= capacity) {
                        wagons.set(i, wagons.get(i) + Integer.parseInt(input[0]));
                        break;
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
        for (int people : wagons) {
            System.out.print(people + " ");
        }
    }
}
