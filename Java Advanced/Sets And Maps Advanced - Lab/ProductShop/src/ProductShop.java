import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> shops = new TreeMap<>();

        String input;
        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(",\\s+", 2);
            String shop = tokens[0];
            String product = tokens[1];
            shops.putIfAbsent(shop, new ArrayList<>());
            shops.get(shop).add(product);
        }
        shops.entrySet()
                .forEach(e -> {
                    System.out.printf("%s->%n", e.getKey());
                    List<String> products = e.getValue();
                    for (String product : products) {
                        String[] tokens = product.split(",\\s+");
                        String currentProduct = tokens[0];
                        double currentPrice = Double.parseDouble(tokens[1]);
                        System.out.printf("Product: %s, Price: %.1f%n", currentProduct, currentPrice);
                    }
                });
    }
}
