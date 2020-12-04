package StackIteratorPackage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("[, ]+"))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);


        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            if (input.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println(exception.getMessage() );
                }
            } else {
                stack.push(Integer.parseInt(input.substring(input.indexOf(" ") + 1)));
            }
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }
}
