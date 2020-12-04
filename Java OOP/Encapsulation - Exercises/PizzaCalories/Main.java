package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = bufferedReader.readLine().split("\\s+");
        Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
        tokens = bufferedReader.readLine().split("\\s+");
        Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
        pizza.setDough(dough);

        String input;
        while (!"END".equals(input = bufferedReader.readLine())) {
            tokens = input.split("\\s+");
            Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
            pizza.addTopping(topping);
        }
        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());
    }
}
