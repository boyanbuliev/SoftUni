package ListIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int index = 0;

    public ListyIterator(String... list) {
        this.list = Arrays.asList(list);
    }

    public boolean move() {
        if (this.index == this.list.size() - 1) {
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    public String print() {
        if (this.list.size() == 0) {
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        return this.list.get(this.index);
    }
}
