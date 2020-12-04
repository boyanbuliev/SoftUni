package GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Box<String>> boxes = new ArrayList<>();

        while (n-- > 0) {
            String line = bf.readLine();
            Box<String> box = new Box<>(line);
            boxes.add(box);
        }

        int[] indexes = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        swap(boxes, firstIndex, secondIndex);

        for (Box<String> box : boxes) {
            System.out.println(box);
        }
    }

    private static <T> void swap(List<Box<T>> boxes, int first, int second) {
        Box<T> temp = boxes.get(first);
        boxes.set(first, boxes.get(second));
        boxes.set(second, temp);
    }
}

