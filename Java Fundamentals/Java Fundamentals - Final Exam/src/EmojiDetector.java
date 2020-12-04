import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        BigInteger threshold = new BigInteger(String.valueOf(1));
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(input);

        while (digitMatcher.find()) {
            int currentDigit = Integer.parseInt(digitMatcher.group());
            threshold = threshold.multiply(BigInteger.valueOf(currentDigit));
        }

        Pattern emojiPattern = Pattern.compile("([*]{2}|[:]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher emojiMatcher = emojiPattern.matcher(input);
        int emojiCounter = 0;

        List<String> coolEmojis = new ArrayList<>();

        while (emojiMatcher.find()) {
            emojiCounter++;
            BigInteger currentEmojiCoolness = new BigInteger(String.valueOf(0));
            String currentEmoji = emojiMatcher.group("emoji");
            for (int i = 0; i < currentEmoji.length(); i++) {
                int currentDigit = currentEmoji.charAt(i);
                currentEmojiCoolness = currentEmojiCoolness.add(BigInteger.valueOf(currentDigit));
            }
            if (currentEmojiCoolness.compareTo(threshold)>=0) {
                coolEmojis.add(emojiMatcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCounter);
        coolEmojis.forEach(System.out::println);
    }
}
