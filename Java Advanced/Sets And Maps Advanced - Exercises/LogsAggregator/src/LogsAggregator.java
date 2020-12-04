import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int minutes = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, new TreeMap<>());
            users.get(user).putIfAbsent(ip, 0);
            users.get(user).put(ip, users.get(user).get(ip) + minutes);
        }

        users.forEach((key, value) -> {
            int[] totalTime = new int[]{0};
            List<String> ips = new ArrayList<>(value.keySet());
            value.forEach((k, v) -> {
                totalTime[0] += v;
            });
            System.out.printf("%s: %d %s%n", key, totalTime[0], ips);
        });
    }
}
