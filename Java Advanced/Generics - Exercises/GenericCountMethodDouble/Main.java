package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Double>> boxes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            double line = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(line);
            boxes.add(box);
        }

        double line = Double.parseDouble(scanner.nextLine());

        System.out.println(compareBoxes(boxes, line));
    }

    private static int compareBoxes(List<Box<Double>> boxes, double line) {
        int counter = 0;
        for (Box<Double> box : boxes) {
            if (box.compareTo(line)) {
                counter++;
            }
        }
        return counter;
    }
}
