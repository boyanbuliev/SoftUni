package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> boxes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            boxes.add(box);
        }

        String line = scanner.nextLine();

        System.out.println(compareBoxes(boxes, line));


    }

    private static int compareBoxes(List<Box<String>> boxes, String line) {
        int counter = 0;
        for (Box<String> box : boxes) {
            if (box.compareTo(line)) {
                counter++;
            }
        }
        return counter;
    }
}
