package CollectionHierarchy;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        return this.add(item, true);
    }
}
