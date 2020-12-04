package TrafficLights;

public enum Signal {
    RED,
    GREEN,
    YELLOW;

    private static Signal[] values = values();

    public Signal getNext() {
        return values[(ordinal() + 1) % values.length];
    }
}