package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String line;
        while (!"END".equals(line = bufferedReader.readLine())) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            persons.add(person);
        }
        int n = Integer.parseInt(bufferedReader.readLine())-1;

        int counter = 1;
        for (int i = 0; i < persons.size(); i++) {
            if (i != n) {
                if (persons.get(i).compareTo(persons.get(n)) > 0) {
                    counter++;
                }
            }
        }
        if (counter == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", counter, persons.size() - counter, persons.size());
        }
    }
}
