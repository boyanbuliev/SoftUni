import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] words = scanner.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> map = new LinkedHashMap<>();


        for (String word : words) {
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }
        List<String> wordsToPrint = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                wordsToPrint.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", wordsToPrint));
    }
}
