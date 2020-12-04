package Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index = 0;

    public ListyIterator(String... list) {
        this.list = Arrays.asList(list);
    }

    public boolean move() {
        if (!this.hasNext()) {
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.index < this.list.size()-1;
    }

    public String print() {
        if (this.list.size() == 0) {
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        return this.list.get(this.index);
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }
}