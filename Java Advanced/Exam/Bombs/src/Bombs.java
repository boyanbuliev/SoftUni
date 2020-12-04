import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        HashMap<Integer, Integer> bombs = new LinkedHashMap<>();
        bombs.put(60, 0);
        bombs.put(40, 0);
        bombs.put(120, 0);

        int[] input = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        input = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        boolean isFilled = false;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (bombs.containsKey(queue.peek() + stack.peek())) {
                bombs.put(queue.peek() + stack.peek(), bombs.get(queue.poll() + stack.pop()) + 1);
            } else {
                stack.push(stack.pop() - 5);
            }
            if (!bombs.containsValue(0) && !bombs.containsValue(1) && !bombs.containsValue(2)) {
                isFilled = true;
                break;
            }
        }
        if (isFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", queue.toString()
                    .replaceAll("[\\[\\]]", ""));
        }
        if (stack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", stack.toString()
                    .replaceAll("[\\[\\]]", ""));
        }
        System.out.printf("Cherry Bombs: %d%n", bombs.get(60));
        System.out.printf("Datura Bombs: %d%n", bombs.get(40));
        System.out.printf("Smoke Decoy Bombs: %d%n", bombs.get(120));
    }
}
