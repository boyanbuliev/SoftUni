import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<String> furniture = new ArrayList<>();
        double price = 0.0;

        while (!"Purchase".equals(input)) {
            Pattern pattern = Pattern.compile
                    (">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String currentItem = matcher.group("furniture");
                double currentPrice = Double.parseDouble(matcher.group("price"))
                        * Double.parseDouble(matcher.group("quantity"));
                furniture.add(currentItem);
                price += currentPrice;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", price);
    }
}
