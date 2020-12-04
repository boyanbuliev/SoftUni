package HotelReservation;

public enum Discount {
    VIP(0.2),
    SECONDVISIT(0.1),
    NONE(0);

    private double discount;

    Discount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
