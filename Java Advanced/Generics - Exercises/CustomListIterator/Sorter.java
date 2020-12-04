package CustomListIterator;

public class Sorter<E extends Comparable<E>> {

    public void sort(CustomList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
