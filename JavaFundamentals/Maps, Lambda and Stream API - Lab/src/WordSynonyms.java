import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if (!map.containsKey(word)) {
                map.put(word, synonym);
            } else {
                map.put(word, String.format("%s, %s", map.get(word), synonym));
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());

        }
    }
}
