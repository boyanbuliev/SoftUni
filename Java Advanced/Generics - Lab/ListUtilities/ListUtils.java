package ListUtilities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0) throw new IllegalArgumentException();
        return list.stream().max(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) throw new IllegalArgumentException();
        return list.stream().min(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> void sort(List<T> collection) {
        Collections.sort(collection);
    }
}
