package EqualityLogic;

import java.util.Comparator;

public class TreeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) == 0 && o1.getAge() - o2.getAge() == 0) {
            return 0;
        }
        return 1;
    }
}
