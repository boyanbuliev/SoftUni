package CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int add(String item) {
        return this.add(item, false);
    }

    @Override
    public String remove() {
        return this.remove(false);
    }

    @Override
    public int getUsed() {
        return this.size();
    }
}
