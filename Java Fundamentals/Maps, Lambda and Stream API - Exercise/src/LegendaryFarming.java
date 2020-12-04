import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] materials = scanner.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> fragments = new HashMap<>();
        Map<String, Integer> scrap = new TreeMap<>();

        fragments.put("shards", 0);
        fragments.put("fragments", 0);
        fragments.put("motes", 0);


        String weapon = "";
        while (true) {
            boolean flag = false;
            for (int i = 1; i < materials.length; i += 2) {
                if ("shards".equals(materials[i]) || "fragments".equals(materials[i])
                        || "motes".equals(materials[i])) {
                    fragments.put(materials[i],
                            fragments.get(materials[i]) + Integer.parseInt(materials[i - 1]));
                    if (fragments.get(materials[i]) >= 250) {
                        switch (materials[i]) {
                            case "shards":
                                weapon = "Shadowmourne";
                                break;
                            case "fragments":
                                weapon = "Valanyr";
                                break;
                            case "motes":
                                weapon = "Dragonwrath";
                                break;
                        }
                        fragments.put(materials[i],
                                fragments.get(materials[i]) - 250);
                        flag = true;
                        break;
                    }
                } else {
                    scrap.putIfAbsent(materials[i], 0);
                    scrap.put(materials[i],
                            scrap.get(materials[i]) + Integer.parseInt(materials[i - 1]));
                }
            }
            if (flag) {
                break;
            }
            materials = scanner.nextLine().toLowerCase().split("\\s+");
        }
        System.out.println(weapon + " obtained!");
        fragments.entrySet()
                .stream()
                .sorted((f1, f2) -> {
                    if (f1.getValue().compareTo(f2.getValue()) == 0) {
                        return f1.getKey().compareTo(f2.getKey());
                    }
                    return f2.getValue().compareTo(f1.getValue());
                })
                .forEach(f -> System.out.printf("%s: %d%n", f.getKey(), f.getValue()));

        scrap.entrySet()
                .forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }
}