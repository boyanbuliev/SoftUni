package com.example.demo.util;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Shampoo;

import java.util.stream.Collectors;

public class PrintUtil {
    public static void printShampoo(Shampoo s) {
        System.out.printf("|%2d | %-20.20s | %-6.6s | %5.2flv. | %-30.30s | %-40.40s |%n",
                s.getId(), s.getBrand(), s.getSize(), s.getPrice(),
                s.getLabel().getTitle() + " " + s.getLabel().getSubtitle(),
                s.getIngredients().stream()
                        .map(Ingredient::getName).collect(Collectors.joining(", ")));

    }
}
