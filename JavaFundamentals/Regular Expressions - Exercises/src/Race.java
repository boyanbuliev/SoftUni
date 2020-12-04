import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String participants = scanner.nextLine();
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<name>[A-Za-z])|(?<distance>\\d)");

        LinkedHashMap<String, Integer> score = new LinkedHashMap<>();

        while (!"end of race".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            StringBuilder name = new StringBuilder();
            int distance = 0;
            while (matcher.find()) {
                if (matcher.group().equals(matcher.group("name"))) {
                    name.append(matcher.group("name"));
                } else if (matcher.group().equals(matcher.group("distance"))) {
                    distance += Integer.parseInt(matcher.group("distance"));
                }
            }
            if (participants.contains(name)) {
                score.putIfAbsent(name.toString(), 0);
                score.put(name.toString(), score.get(name.toString()) + distance);
            }
            input = scanner.nextLine();
        }
        int[] number = {1};

        score.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .limit(3)
                .forEach(p -> {
                    switch (number[0]) {
                        case 1:
                            System.out.printf("1st place: %s%n", p.getKey());
                            break;
                        case 2:
                            System.out.printf("2nd place: %s%n", p.getKey());
                            break;
                        case 3:
                            System.out.printf("3rd place: %s%n", p.getKey());
                            break;
                    }
                    number[0]++;
                });


    }
}