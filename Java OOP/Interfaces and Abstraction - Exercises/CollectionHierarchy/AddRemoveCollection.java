package CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public int add(String item) {
        return this.add(item, false);
    }

    @Override
    public String remove() {
        return this.remove(true);
    }
}
