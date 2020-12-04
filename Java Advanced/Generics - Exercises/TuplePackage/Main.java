package TuplePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Tuple> tuples = new ArrayList<>();

        String[] firstItem = scanner.nextLine().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(firstItem[0]);
        sb.append(" ");
        sb.append(firstItem[1]);

        Tuple<String, String> tuple1 = new Tuple<>(sb.toString(), firstItem[2]);
        tuples.add(tuple1);
        String[] secondItem = scanner.nextLine().split("\\s+");

        Tuple<String, Integer> tuple2 = new Tuple<>(secondItem[0], Integer.parseInt(secondItem[1]));
        tuples.add(tuple2);

        String[] thirdItem = scanner.nextLine().split("\\s+");

        Tuple<Integer, Double> tuple3 = new Tuple<>
                (Integer.parseInt(thirdItem[0]), Double.parseDouble(thirdItem[1]));
        tuples.add(tuple3);

        for (Tuple tuple : tuples) {
            System.out.println(tuple);
        }
    }
}
