package TuplePackage;

public class Tuple<T, E> {
    private T item1;
    private E item2;

    Tuple(T item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1.toString(), this.item2.toString());
    }
}
