package CustomListSorter;

import java.util.Arrays;
import java.util.Comparator;

public class CustomList<E extends Comparable<E>> {
    private static final int INITIAL_SIZE = 4;
    private Object[] list;
    private int size;

    public CustomList() {
        this.list = new Object[INITIAL_SIZE];
    }

    public void add(E element) {
        if (this.size == this.list.length) {
            grow(this.list);
        }
        this.list[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public void remove(int index) {
        checkIndex(index);
        this.list[index] = null;
        shift(index);
        this.size--;
        if (this.size * 2 == this.list.length) {
            shrink();
        }
    }

    public boolean contains(Object obj) {
        for (Object o : list) {
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void swap(int first, int second) {
        checkIndex(first);
        checkIndex(second);
        Object temp = this.list[first];
        this.list[first] = this.list[second];
        this.list[second] = temp;
    }

    @SuppressWarnings("unchecked")
    public int countGreaterThan(E element) {
        int counter = 0;
        for (int i = 0; i < this.size; i++) {
            E currentObj = (E) this.list[i];
            if (currentObj.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    @SuppressWarnings("unchecked")
    public E getMax() {
        return Arrays.stream(this.list)
                .limit(this.size)
                .map(e -> (E) e)
                .max(Comparator.comparing(e -> e))
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public E getMin() {
        return Arrays.stream(this.list)
                .limit(this.size)
                .map(e -> (E) e)
                .min(Comparator.comparing(e -> e))
                .orElse(null);
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.list[i]);
        }
    }

    public void sort() {
        new Sorter<>().sort(this);

    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) this.list[index];
    }

    private void shrink() {
        this.list = Arrays.copyOf(this.list, this.list.length / 2);
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list[this.size - 1] = null;
    }

    private void checkIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException(
                    "Index out of bounds for " + index + " Custom List size of: " + this.size);
        }
    }

    private void grow(Object[] list) {
        this.list = Arrays.copyOf(this.list, this.list.length * 2);
    }
}







