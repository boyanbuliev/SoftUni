package StudentSystemPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input;
        while (!"Exit".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Create")) {
                studentSystem.create(tokens);
            } else if (tokens[0].equals("Show")) {
                System.out.println(studentSystem.show(tokens[1]));
            }
        }
    }
}
