package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] indexes;

    public Lake(int[] indexes) {
        this.indexes = indexes;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog(this.indexes);
    }
}
