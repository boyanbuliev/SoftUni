import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scanner.nextLine());
            map.putIfAbsent(resource, 0);
            map.put(resource, map.get(resource) + quantity);
            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
