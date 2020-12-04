package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(input);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int[] cords = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Point point = new Point(cords);
            System.out.println(rectangle.contains(point));
        }
    }
}
