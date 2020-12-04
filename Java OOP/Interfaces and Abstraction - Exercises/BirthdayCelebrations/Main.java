package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        String input;

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if ("Citizen".equals(tokens[0])) {
                birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]),
                        tokens[3], tokens[4]));
            } else if ("Pet".equals(tokens[0])) {
                birthables.add(new Pet(tokens[1], tokens[2]));
            }
        }
        input = scanner.nextLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(input)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
