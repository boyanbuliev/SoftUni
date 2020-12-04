package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] people = bufferedReader.readLine().split(";");
        List<Person> personList = new ArrayList<>();


        for (String person : people) {
            String personName = person.split("=")[0];
            double money = Double.parseDouble(person.split("=")[1]);

            try {
                Person currentPerson = new Person(personName, money);
                personList.add(currentPerson);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] items = bufferedReader.readLine().split(";");
        List<Product> productList = new ArrayList<>();

        for (String item : items) {
            String itemName = item.split("=")[0];
            double cost = Double.parseDouble(item.split("=")[1]);
            try {
                Product currentProduct = new Product(itemName, cost);
                productList.add(currentProduct);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        String input;
        while (!"END".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");
            for (Person person : personList) {
                if (person.getName().equals(tokens[0])) {
                    for (Product product : productList) {
                        if (product.getName().equals(tokens[1])) {
                            try {
                                person.buyProduct(product);
                                System.out.println(person.getName() + " bought " + product.getName());
                            } catch (IllegalStateException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
        }
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}

