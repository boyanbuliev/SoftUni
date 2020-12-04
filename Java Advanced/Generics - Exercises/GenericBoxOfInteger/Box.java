package GenericBoxOfInteger;

public class Box {
    private Object value;

    public Box(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.getClass().getName() + ": " + this.value;
    }
}
