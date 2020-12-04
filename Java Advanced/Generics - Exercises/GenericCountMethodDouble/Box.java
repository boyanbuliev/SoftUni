package GenericCountMethodDouble;

public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public boolean compareTo(T line) {
        return this.value.compareTo(line) > 0;
    }
}
