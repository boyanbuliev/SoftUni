package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int maxSize;
    private List<String> items;

    public Collection() {
        this.maxSize = 100;
        items = new ArrayList<>();
    }

    protected int add(String str, boolean addAtTheEnd) {
        int index = 0;
        if (addAtTheEnd) {
            this.items.add(str);
            index = items.size() - 1;
        } else {
            this.items.add(0, str);
        }
        return index;
    }

    protected String remove(boolean removeAtTheEnd) {
        if (removeAtTheEnd) {
            return this.items.remove(items.size() - 1);
        } else {
            return this.items.remove(0);
        }
    }

    protected int size() {
        return this.items.size();
    }
}
