package com.example.demo.controllers;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Label;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import com.example.demo.repositories.LabelRepository;
import com.example.demo.repositories.ShampooRepository;
import com.example.demo.services.IngredientService;
import com.example.demo.services.LabelService;
import com.example.demo.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {
    private final LabelRepository labelRepository;
    private final ShampooService shampooService;
    private final ShampooRepository shampooRepository;
    private final IngredientService ingredientService;
    private final LabelService labelService;
    private final Scanner scanner;

    @Autowired
    public AppController(LabelRepository labelRepository, ShampooService shampooService, ShampooRepository shampooRepository, IngredientService ingredientService, LabelService labelService, Scanner scanner) {
        this.labelRepository = labelRepository;
        this.shampooService = shampooService;
        this.shampooRepository = shampooRepository;
        this.ingredientService = ingredientService;
        this.labelService = labelService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
//        String labelSubtitle = scanner.nextLine();
//        this.labelRepository.findAllBySubtitle(labelSubtitle)
//                .forEach(l -> System.out.printf("%d. %s <-> %s\r\n", l.getId(), l.getTitle(), l.getSubtitle()));
        while (true) {
            String command = scanner.nextLine();
            //                    this.labelRepository.findAllBySubtitle(labelSubtitle)
            //                            .forEach(l -> System.out.printf("%d. %s <-> %s\r\n", l.getId(), l.getTitle(), l.getSubtitle()));
            //                    this.shampooRepository.searchByBrand(labelSubtitle)
            //                            .forEach(s -> System.out.printf("%d %s %.2f%n", s.getId(), s.getBrand(), s.getPrice()));
            switch (command) {
                case "select" -> {
                    String labelSubtitle = scanner.nextLine();
                    this.shampooRepository.findAllBySize(Size.valueOf(labelSubtitle.toUpperCase()))
                            .forEach(s -> System.out.printf("%s %s %.2f%n", s.getBrand(), s.getSize(), s.getPrice()));
                }
                case "update" -> {
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    this.shampooRepository.updateShampooPriceBySize(price, size);
                }
                case "delete" -> {
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    this.shampooRepository.deleteShampoosByPrice(price);
                }
                case "group by" -> {
                    this.shampooRepository.groupAllShampoosBySize()
                            .forEach(r -> System.out.println(r[0] + " " + r[1]));
                }
                case "1" -> {
                    String shampooSize = scanner.nextLine().toUpperCase();
                    Size size = Size.valueOf(shampooSize);
                    this.shampooService.selectShampoosBySize(size)
                            .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
                }
                case "2" -> {
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                    Label label = labelRepository.getById((long) Integer.parseInt(scanner.nextLine()));
                    this.shampooService.selectShampoosBySizeOrLabel(size, label)
                            .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
                }
                case "3" -> {
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    this.shampooService.selectShampoosByPrice(price)
                            .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
                }
                case "4" -> {
                    String name = scanner.nextLine();
                    this.ingredientService.selectIngredientsByName(name)
                            .stream().map(Ingredient::getName)
                            .forEach(System.out::println);
                }
                case "5" -> {
                    List<String> names = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        names.add(scanner.nextLine());
                    }
                    this.ingredientService.selectIngredientsByNames(names)
                            .forEach(i -> System.out.println(i.getName()));
                }
                case "6" -> {
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    System.out.println(this.shampooService.countShampoosByPrice(price));
                }
                case "7" -> {
                    List<Ingredient> ingredients = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        ingredients.add(this.ingredientService.findByName(scanner.nextLine()));
                    }
                    this.shampooService.selectShampoosByIngredients(ingredients)
                            .forEach(s -> System.out.println(s.getBrand()));
                }
                case "8" -> {
                    int count = Integer.parseInt(scanner.nextLine());
                    this.shampooService.selectShampoosByIngredientsCount(count)
                            .forEach(s -> System.out.println(s.getBrand()));
                }
                case "9" -> {
                    String name = "Macadamia Oil";
                    Ingredient ingredient = ingredientService.findByName(name);
                    shampooRepository.selectShampoosWithIngredient(ingredient)
                            .forEach(s -> s.getIngredients().remove(ingredient));
                    this.ingredientService.deleteIngredientsByName(name);
                }
                case "exit" -> System.exit(0);
            }
        }
    }
}
