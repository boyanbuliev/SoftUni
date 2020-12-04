import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+:\\s+");
            String course = tokens[0];
            String student = tokens[1];
            courses.putIfAbsent(course, new ArrayList<>());
            if (!courses.get(course).contains(student))
                courses.get(course).add(student);
            input = scanner.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .forEach(c -> {
                    System.out.printf("%s: %d%n", c.getKey(), c.getValue().size());
                    c.getValue().stream().sorted().forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}