package PizzaCalories;

public enum DoughFlourTypeAndCalories {
    WHITE("White", 1.5),
    WHOLEGRAIN("Wholegrain", 1.0);

    private String type;
    private double modifier;

    DoughFlourTypeAndCalories(String type, double modifier) {
        this.type = type;
        this.modifier = modifier;
    }

    public String getType() {
        return type;
    }

    public double getModifier() {
        return modifier;
    }
}
