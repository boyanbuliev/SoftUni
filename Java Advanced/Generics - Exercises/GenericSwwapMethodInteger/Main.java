package GenericSwwapMethodInteger;

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
        List<Box<Integer>> boxes = new ArrayList<>();

        while (n-- > 0) {
            int line = Integer.parseInt(bf.readLine());
            Box<Integer> box = new Box<>(line);
            boxes.add(box);
        }
        int[] indexes = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int first = indexes[0];
        int second = indexes[1];

        swap(boxes, first, second);
        for (Box<Integer> box : boxes) {
            System.out.println(box);
        }
    }

    private static <T> void swap(List<Box<T>> boxes, int first, int second) {
        Box<T> temp = boxes.get(first);
        boxes.set(first, boxes.get(second));
        boxes.set(second, temp);
    }
}
