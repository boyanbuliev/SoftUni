package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            Identifiable current = createNewIdentifiable(input);
            identifiables.add(current);
        }
        input = scanner.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(input)) {
                System.out.println(identifiable.getId());
            }
        }
    }

    private static Identifiable createNewIdentifiable(String input) {
        String[] tokens = input.split("\\s+");
        switch (tokens.length) {
            case 2:
                return new Robot(tokens[0], tokens[1]);
            default:
                return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        }
    }
}
