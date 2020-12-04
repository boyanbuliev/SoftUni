package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        TreeSet<Person> firstSet = new TreeSet<>(new CompareByName());
        TreeSet<Person> secondSet = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            firstSet.add(person);
            secondSet.add(person);
        }

        firstSet.forEach(System.out::println);
        secondSet.forEach(System.out::println);
    }
}
