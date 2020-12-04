package CustomListSorter;

public class Sorter<E extends Comparable<E>> {

    public <E extends Comparable<E>> CustomList<E> sort(CustomList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    list.swap(i, j);
                }
            }
        }
        return list;
    }
}
