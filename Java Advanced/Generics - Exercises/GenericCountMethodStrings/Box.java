package GenericCountMethodStrings;

public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public boolean compareTo(T value) {
        if (this.value.compareTo(value) > 0) {
            return true;
        }
        return false;
    }
}
