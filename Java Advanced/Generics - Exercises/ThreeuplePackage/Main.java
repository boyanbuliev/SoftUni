package ThreeuplePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple> threeuples = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            if (tokens.length == 4) {
                String name = tokens[0] + " " + tokens[1];
                Threeuple<String, String, String> threeuple =
                        new Threeuple<>(name, tokens[2], tokens[3]);
                threeuples.add(threeuple);
            } else {
                try {
                    int liters = Integer.parseInt(tokens[1]);
                    boolean drunkOrNot;
                    if (tokens[2].equals("drunk")) {
                        drunkOrNot = true;
                    } else {
                        drunkOrNot = false;
                    }
                    Threeuple<String, Integer, Boolean> threeuple =
                            new Threeuple<>(tokens[0], liters, drunkOrNot);
                    threeuples.add(threeuple);

                } catch (NumberFormatException e) {
                    double balance = Double.parseDouble(tokens[1]);
                    Threeuple<String, Double, String> threeuple =
                            new Threeuple<>(tokens[0], balance, tokens[2]);
                    threeuples.add(threeuple);
                }
            }
        }
        for (Threeuple threeuple : threeuples) {
            System.out.println(threeuple);
        }
    }
}
