package com.example.demo.services.impl;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.models.dtos.ProductSeedDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService, UserService userService) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        if (productRepository.count() != 0) {
            return;
        }
        Arrays.stream(productSeedDtos).forEach(d -> {
            if (validationUtil.isValid(d)) {
                Product product = modelMapper.map(d, Product.class);
                product.setCategories(randomCategories());
                product.setSeller(userService.getRandomUser());
                if (randomNumberGenerator(10) != 0) {
                    product.setBuyer(userService.getRandomUser());
                }
                productRepository.save(product);
            } else {
                validationUtil.violations(d).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            }
        });
    }


    private Set<Category> randomCategories() {
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < randomNumberGenerator(3) + 1; i++) {
            categories.add(categoryService.getCategories()
                    .get(randomNumberGenerator(categoryService.getCategories().size())));
        }
        return categories;
    }

    private int randomNumberGenerator(int bound) {
        return new Random().nextInt(bound);
    }
}
