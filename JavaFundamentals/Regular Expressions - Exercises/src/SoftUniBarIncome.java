import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile
                ("%(?<name>[A-Z][a-z]+)%[^\\|\\$\\%\\.]*<(?<product>[\\w]+)>[^\\|\\$\\%\\.]*\\|" +
                        "(?<quantity>\\d+)\\|[^\\|\\$\\%\\.\\d]*(?<price>\\d+\\.?\\d*)\\$");


        double totalIncome = 0.0;

        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double income = quantity * price;
                System.out.printf("%s: %s - %.2f%n", name, product, income);
                totalIncome += income;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}

