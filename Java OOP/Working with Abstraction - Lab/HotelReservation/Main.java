package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String season = input[2].toUpperCase();
        String discount = input[3].toUpperCase();

        System.out.printf("%.2f", PriceCalculator.CalculatePrice(price, days,
                Season.valueOf(season), Discount.valueOf(discount)));
    }
}
