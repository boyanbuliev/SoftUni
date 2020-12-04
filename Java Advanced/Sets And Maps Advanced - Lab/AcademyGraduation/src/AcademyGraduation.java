import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, double[]> students = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            students.put(name, grades);
        }
        students.entrySet()
                .forEach(e -> {
                    double avgScore = 0;
                    for (double value : e.getValue()) {
                        avgScore += value;
                    }
                    avgScore /= e.getValue().length;
                    System.out.printf("%s is graduated with %s%n", e.getKey(), avgScore);
                });
    }
}
