package com.example.demo.controllers;

import com.example.demo.models.dtos.CategorySeedDto;
import com.example.demo.models.dtos.ProductSeedDto;
import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.example.demo.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AppController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] productSeedDtos = gson.fromJson(new FileReader(PRODUCTS_FILE_PATH), ProductSeedDto[].class);
        productService.seedProducts(productSeedDtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] userSeedDtos = gson.fromJson(new FileReader(USERS_FILE_PATH), UserSeedDto[].class);
        userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDto[] categorySeedDtos = gson.fromJson(new FileReader(CATEGORIES_FILE_PATH),
                CategorySeedDto[].class);
        categoryService.seedCategories(categorySeedDtos);
    }
}
