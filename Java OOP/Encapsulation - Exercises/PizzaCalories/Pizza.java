package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        toppings = new ArrayList<>();
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void setName(String name) {
        if (name.length() == 0 || name.trim().isEmpty()) {
            throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() == numberOfToppings) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = 0;
        totalCalories += this.dough.calculateCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }
}