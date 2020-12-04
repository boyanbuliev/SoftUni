import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTimes = new int[input.length];
        int[] currentRobotTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("-");
            robots[i] = tokens[0];
            processTimes[i] = Integer.parseInt(tokens[1]);
            currentRobotTime[i] = 0;
        }

        int[] startingTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int time = startingTime[0] * 3600 + startingTime[1] * 60 + startingTime[2];
        ArrayDeque<String> itemsQueue = new ArrayDeque<>();

        String product = "";

        while (!(product = scanner.nextLine()).equals("End")) {
            itemsQueue.offer(product);
        }
        while (!itemsQueue.isEmpty()) {
            time++;
            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTime[i] > 0) {
                    currentRobotTime[i]--;
                }
            }

            String currentItem = itemsQueue.poll();
            boolean flag = false;
            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTime[i] == 0) {
                    System.out.printf("%s - %s %s%n",
                            robots[i], currentItem,
                            getTime(time));
                    currentRobotTime[i] = processTimes[i];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                itemsQueue.offer(currentItem);
            }
        }
    }

    public static String getTime(int time) {
        int hours = time / 3600 % 24;
        int minutes = time / 60 % 60;
        int seconds = time % 60;
        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }
}