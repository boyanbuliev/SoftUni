package ListIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = new ListyIterator(
                Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .skip(1)
                        .toArray(String[]::new));

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.print());
                    }catch (UnsupportedOperationException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
}
