import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, ArrayList<String>> forceSides = new HashMap<>();
        String input = scanner.nextLine();
        ArrayList<String> existingUsers = new ArrayList<>();

        while (!"Lumpawaroo".equals(input)) {
            if (input.contains("|")) {
                String[] tokens = input.split(" \\| ");
                String side = tokens[0];
                String user = tokens[1];
                if (!existingUsers.contains(user)) {
                    forceSides.putIfAbsent(side, new ArrayList<>());
                    forceSides.get(side).add(user);
                    existingUsers.add(user);
                }
            } else {
                String[] tokens = input.split(" -> ");
                String user = tokens[0];
                String side = tokens[1];
                if (!existingUsers.contains(user)) {
                    forceSides.putIfAbsent(side, new ArrayList<>());
                    forceSides.get(side).add(user);
                    existingUsers.add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                } else {
                    for (Map.Entry<String, ArrayList<String>> entry : forceSides.entrySet()) {
                        entry.getValue().remove(user);
                    }
                    forceSides.putIfAbsent(side, new ArrayList<>());
                    forceSides.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);

                }
            }
            input = scanner.nextLine();
        }
        forceSides.entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    if (s2.getValue().size() - s1.getValue().size() == 0) {
                        return s1.getKey().compareTo(s2.getKey());
                    }
                    return s2.getValue().size() - s1.getValue().size();
                })
                .filter(s -> s.getValue().size() > 0)
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %s%n", s.getKey(),
                            s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted((u1, u2) -> u1.compareTo(u2))
                            .forEach(u -> System.out.printf("! %s%n", u));
                });
    }
}
