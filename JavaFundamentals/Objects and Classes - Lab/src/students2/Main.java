package students2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!"end".equals(input)) {
            String[] studentParts = input.split(" ");
            int age = Integer.parseInt(studentParts[2]);

            Student found = findByFirstAndLastName(students, studentParts[0], studentParts[1]);
            if (found != null) {
                students.remove(found);
            }
            Student student = new Student(studentParts[0], studentParts[1], age, studentParts[3]);
            students.add(student);

            input = scanner.nextLine();
        }

        String city = scanner.nextLine();

        students.stream().filter(s -> s.getHometown().equals(city))
                .forEach(s -> System.out.println(s.getString()));

    }

    private static Student findByFirstAndLastName(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
}
