package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            String grade = input[2];
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        List<Student> sortedStudents = students.stream()
                .sorted((s1, s2) -> s1.getGrade().compareTo(s2.getGrade())).collect(Collectors.toList());
        Collections.reverse(sortedStudents);
        sortedStudents.forEach(s -> System.out.println(s));

    }
}
