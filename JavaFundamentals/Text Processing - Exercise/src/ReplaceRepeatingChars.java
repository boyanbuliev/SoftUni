import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        text.append(scanner.nextLine());
        for (int i = 0; i < text.length()-1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                text.deleteCharAt(i);
                i -= 1;
            }
        }


        System.out.println(text);
    }
}
