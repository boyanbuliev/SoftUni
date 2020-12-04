package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.length() < 1 || name.trim().isEmpty()) {
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalStateException(String.format("%s can't afford  %s",
                    this.getName(), product.getName()));
        }
        this.products.add(product);
        this.money -= product.getCost();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name + " - ");
        for (Product product : products) {
            sb.append(product.getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}