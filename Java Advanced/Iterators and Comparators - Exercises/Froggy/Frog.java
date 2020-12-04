package Froggy;

import java.util.Iterator;

public class Frog implements Iterator<Integer> {
    private int[] indexes;
    private int index = 0;

    public Frog(int[] indexes) {
        this.indexes = indexes;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.indexes.length;
//        if (this.index < this.indexes.length || this.index % 2 == 0) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public Integer next() {
        int current = this.indexes[this.index];
        this.index += 2;
        if (this.index >= this.indexes.length && this.index % 2 == 0) {
            this.index = 1;
        }
        return current;
//        if (this.index < this.indexes.length) {
//            int current = this.indexes[this.index];
//            this.index += 2;
//            return current;
//        } else {
//            this.index = 1;
//            int current = this.indexes[this.index];
//            this.index += 2;
//            return current;
//        }
    }
}