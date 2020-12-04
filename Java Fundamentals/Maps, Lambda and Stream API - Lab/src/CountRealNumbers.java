import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> map = new TreeMap<>();

        int counter = 1;

        for (double number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        for (Map.Entry<Double, Integer> doubleIntegerEntry : map.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.####");
            System.out.printf("%s -> %d%n",df.format(doubleIntegerEntry.getKey()), doubleIntegerEntry.getValue());
        }

    }
}
