import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalCoins = 0;

        while (!input.equals("Start")) {
            double coinsConverted = Double.parseDouble(input);
            if (coinsConverted == 0.1 || coinsConverted == 0.2 || coinsConverted == 0.5
                    || coinsConverted == 1 || coinsConverted == 2) {
                totalCoins += coinsConverted * 100;
            } else {
                System.out.printf("Cannot accept %.2f%n", coinsConverted);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (totalCoins >= 200) {
                        System.out.printf("Purchased %s%n", input);
                        totalCoins -= 200;
                    } else {
                        System.out.println("Sorry, not enough money.");
                    }
                    break;
                case "Water":
                    if (totalCoins >= 70) {
                        System.out.printf("Purchased %s%n", input);
                        totalCoins -= 70;
                    } else {
                        System.out.println("Sorry, not enough money.");
                    }
                    break;
                case "Crisps":
                    if (totalCoins >= 150) {
                        System.out.printf("Purchased %s%n", input);
                        totalCoins -= 150;
                    } else {
                        System.out.println("Sorry, not enough money.");
                    }
                    break;
                case "Soda":
                    if (totalCoins >= 80) {
                        System.out.printf("Purchased %s%n", input);
                        totalCoins -= 80;
                    } else {
                        System.out.println("Sorry, not enough money.");
                    }
                    break;
                case "Coke":
                    if (totalCoins >= 100) {
                        System.out.printf("Purchased %s%n", input);
                        totalCoins -= 100;
                    } else {
                        System.out.println("Sorry, not enough money.");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalCoins / 100);
    }
}

