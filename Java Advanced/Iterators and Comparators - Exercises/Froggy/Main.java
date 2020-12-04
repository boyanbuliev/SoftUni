package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] items = Arrays.stream(bf.readLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(items);

        String line = bf.readLine();

        StringBuilder output = new StringBuilder();
        for (Integer integer : lake) {
            output.append(integer).append(", ");
        }
        System.out.println(output.substring(0, output.length() - 2));
    }
}
