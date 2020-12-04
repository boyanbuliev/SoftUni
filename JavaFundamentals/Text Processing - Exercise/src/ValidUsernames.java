import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");

        for (String name : names) {
            if (name.length() >= 3 && name.length() <= 16) {
                boolean isValid = true;
                for (char c : name.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && c != 45 && c != 95) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(name);
                }
            }
        }
    }
}
