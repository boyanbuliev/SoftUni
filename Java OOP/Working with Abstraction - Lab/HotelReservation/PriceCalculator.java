package HotelReservation;

public class PriceCalculator {
    public static double CalculatePrice(double pricePerDay, int numberOfDays,
                                        Season season, Discount discount) {
        int multiplier = season.getValue();
        double discountMultiplier = discount.getDiscount();
        double totalPrice = multiplier * numberOfDays * pricePerDay -
                discountMultiplier * multiplier * numberOfDays * pricePerDay;

        return totalPrice;
    }
}
