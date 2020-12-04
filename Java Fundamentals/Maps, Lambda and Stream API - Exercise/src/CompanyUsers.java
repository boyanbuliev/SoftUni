import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> companies = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+->\\s+");
            String company = tokens[0];
            String id = tokens[1];
            companies.putIfAbsent(company, new ArrayList<>());
            if (!companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }
            input = scanner.nextLine();
        }
        companies
                .entrySet()
                .forEach(c -> {
                    System.out.println(c.getKey());
                    for (int i = 0; i < c.getValue().size(); i++) {
                        System.out.printf("-- %s%n", c.getValue().get(i));
                    }
                });
    }
}
