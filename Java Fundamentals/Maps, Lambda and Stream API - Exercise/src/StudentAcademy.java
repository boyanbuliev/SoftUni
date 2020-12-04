import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        students
                .entrySet()
                .stream()
                .filter(s -> s
                        .getValue()
                        .stream()
                        .mapToDouble(d -> d)
                        .average()
                        .getAsDouble() >= 4.50)
                .sorted((s1, s2) -> {
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(s -> System.out.printf("%s -> %.2f%n", s.getKey(),
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
    }
}
