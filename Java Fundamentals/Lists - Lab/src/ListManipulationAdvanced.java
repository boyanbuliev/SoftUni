import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        for (int number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        for (int number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    for (int number : numbers) {
                        switch (command[1]) {
                            case "<":
                                if (number < Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                                break;
                            case ">":
                                if (number > Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                                break;
                            case "<=":
                                if (number <= Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                                break;
                            case ">=":
                                if (number >= Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                                break;
                        }
                    }
                    System.out.println();
            }


            command = scanner.nextLine().split(" ");
        }

    }
}
