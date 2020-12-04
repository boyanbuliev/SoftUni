import java.util.Scanner;

public class Orders {
    private static void totalPrice(String product, int quantity) {
        double productPrice = 0;
        switch (product) {
            case "coffee":
                productPrice = 1.5;
                break;
            case "water":
                productPrice = 1;
                break;
            case "coke":
                productPrice = 1.4;
                break;
            case "snacks":
                productPrice = 2;
                break;
        }
        System.out.printf("%.2f", productPrice * quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        totalPrice(product, quantity);
    }
}
