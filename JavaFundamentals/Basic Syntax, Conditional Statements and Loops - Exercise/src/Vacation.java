import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

        if (type.equals("Students")) {
            switch (day) {
                case "Friday":
                    price = 8.45;
                    break;
                case "Saturday":
                    price = 9.8;
                    break;
                case "Sunday":
                    price = 10.46;
                    break;
            }
            if (n >= 30) {
                price *= 0.85;
            }
        } else if (type.equals("Business")) {
            switch (day) {
                case "Friday":
                    price = 10.9;
                    break;
                case "Saturday":
                    price = 15.6;
                    break;
                case "Sunday":
                    price = 16;
                    break;
            }
            if (n >= 100) {
                n -= 10;
            }
        } else {
            switch (day) {
                case "Friday":
                    price = 15;
                    break;
                case "Saturday":
                    price = 20;
                    break;
                case "Sunday":
                    price = 22.5;
                    break;
            }
            if (n >= 10 && n <= 20) {
                price *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", price * n);
    }
}

