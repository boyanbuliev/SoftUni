import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] lootbox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i : lootbox) {
            queue.offer(i);
        }
        lootbox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i : lootbox) {
            stack.push(i);
        }

        int sum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            if ((queue.peek() + stack.peek()) % 2 == 0) {
                sum += queue.poll() + stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
