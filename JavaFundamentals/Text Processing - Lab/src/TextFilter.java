import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String replacement = "";
            for (int j = 0; j < bannedWords[i].length(); j++) {
                replacement += "*";
            }
            while (text.contains(bannedWords[i])) {
                text = text.replace(bannedWords[i], replacement);
            }
        }
        System.out.println(text);
    }
}
