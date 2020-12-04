import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        text.append(scanner.nextLine());

        StringBuilder formattedText = new StringBuilder();

        for (char c : text.toString().toCharArray()) {
            formattedText.append((char) (c + 3));
        }
        System.out.println(formattedText);
    }
}
