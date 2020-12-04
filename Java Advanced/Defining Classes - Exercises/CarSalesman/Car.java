package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.model + ":");
        builder.append(System.lineSeparator())
                .append(this.engine.toString())
                .append(System.lineSeparator())
                .append("Weight: ")
                .append(this.weight == -1 ? "n/a" : String.valueOf(this.weight))
                .append(System.lineSeparator())
                .append("Color: ")
                .append(this.color);

        return builder.toString();
    }
}
