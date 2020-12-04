import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> numbers = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(",\\s+");
            if (tokens[0].equals("IN")) {
                numbers.add(tokens[1]);
            } else {
                numbers.remove(tokens[1]);
            }
        }
        if (numbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            numbers.forEach(System.out::println);
        }
    }
}
