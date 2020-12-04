import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String currentURL = "";

        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (!stack.isEmpty()) {
                    if (!currentURL.isEmpty()) {
                        queue.addFirst(currentURL);
                    } else {
                        System.out.println("no next URLs");
                        input = scanner.nextLine();
                        continue;
                    }

                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else if ("forward".equals(input)) {
                if (!queue.isEmpty()) {
                    stack.push(currentURL);
                    currentURL = queue.poll();
                } else {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                }

            } else {
                if (!currentURL.isEmpty()) {
                    stack.push(currentURL);
                }
                currentURL = input;
                queue.clear();
            }

            System.out.println(currentURL);
            input = scanner.nextLine();
        }

    }
}
