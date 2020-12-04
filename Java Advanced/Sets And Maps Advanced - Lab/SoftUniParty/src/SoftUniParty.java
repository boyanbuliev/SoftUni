import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> guests = new TreeSet<>();

        String input;

        while (!"PARTY".equals(input = scanner.nextLine())) {
            guests.add(input);

        }
        while (!"END".equals(input = scanner.nextLine())) {
            guests.remove(input);
        }

        System.out.println(guests.size());
        guests.forEach(System.out::println);

    }
}
