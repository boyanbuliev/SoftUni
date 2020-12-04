import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double grades = 0;
            for (Double aDouble : entry.getValue()) {
                grades += aDouble;
            }
            int totalgrades = entry.getValue().size();
            double avgGrade = grades / totalgrades;
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(),
                    getGrades(entry.getValue()), avgGrade);
        }
    }

    private static String getGrades(List<Double> value) {
        return value.stream()
                .map(grade -> String.format("%.2f", grade))
                .collect(Collectors.joining(" "));
    }
}
