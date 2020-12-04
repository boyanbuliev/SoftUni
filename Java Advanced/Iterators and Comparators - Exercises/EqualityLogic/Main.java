package EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            if (treeSet.size() > 0) {
                boolean isEqual = false;
                for (Person person1 : treeSet) {
                    if (person.compareTo(person1) == 0) {
                        isEqual = true;
                        break;
                    }
                }
                if (!isEqual) {
                    treeSet.add(person);
                }
            } else {
                treeSet.add(person);
            }

            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
