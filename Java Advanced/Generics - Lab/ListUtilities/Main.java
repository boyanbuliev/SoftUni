package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Person implements Comparable<Person> {
        public int rating;

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.rating, other.rating);
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));
        ListUtils.sort(people);
    }
}
