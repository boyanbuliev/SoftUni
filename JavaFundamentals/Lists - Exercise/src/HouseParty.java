import java.util.ArrayList;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> peopleAttending = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (!peopleAttending.contains(input[0])) {
                if (!"not".equals(input[2])) {
                    peopleAttending.add(input[0]);
                } else {
                    System.out.printf("%s is not in the list!%n", input[0]);
                }
            } else {
                if (!"not".equals(input[2])) {
                    System.out.printf("%s is already in the list!%n", input[0]);
                } else {
                    peopleAttending.remove(input[0]);
                }
            }
        }
        for (String people : peopleAttending) {
            System.out.println(people);
        }
    }
}
