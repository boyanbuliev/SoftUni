import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        String currentURL = "";

        while (!"Home".equals(navigation)) {
            if (navigation.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.isEmpty()) {
                    stack.push(currentURL);
                }
                currentURL = navigation;
            }
            System.out.println(currentURL);
            navigation = scanner.nextLine();
        }
    }
}
