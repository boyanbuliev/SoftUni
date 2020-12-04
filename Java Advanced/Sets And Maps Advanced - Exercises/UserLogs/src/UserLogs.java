import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();


        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String user = tokens[2].split("=")[1];
            String ip = tokens[0].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, 0);
            users.get(user).put(ip, users.get(user).get(ip) + 1);
        }

        users.forEach((k, v) -> {
            System.out.println(k + ":");
            StringBuilder sb = new StringBuilder();
            v.forEach((key, value) -> {
                sb.append(String.format("%s => %d, ", key, value));
            });
            System.out.println(sb.substring(0, sb.length() - 2) + ".");
        });

    }
}