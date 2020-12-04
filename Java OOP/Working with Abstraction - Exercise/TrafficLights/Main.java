package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] trafficLights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] current = new String[trafficLights.length];
            for (int i = 0; i < trafficLights.length; i++) {
                current[i] = String.valueOf(Signal.valueOf(trafficLights[i]).getNext());
            }
            trafficLights = current;
            System.out.println(String.join(" ", trafficLights));
        }
    }
}
