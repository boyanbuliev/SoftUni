import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(toRemove)) {
            int toRemoveIndex = text.indexOf(toRemove);
            int toRemoveLength = toRemove.length();
            text = text.substring(0, toRemoveIndex) +
                    text.substring(toRemoveIndex + toRemoveLength);
        }
        System.out.println(text);
    }
}
