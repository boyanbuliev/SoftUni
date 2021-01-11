package com.example.demo.services.impl;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.models.dtos.ProductReturnDto;
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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
                product.setCategories(categoryService.getRandomCategories());
                product.setSeller(userService.getRandomUser());
                if (new Random().nextInt(2) != 0) {
                    product.setBuyer(userService.getRandomUser());
                }
                productRepository.save(product);
            } else {
                validationUtil.violations(d).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            }
        });
    }

    @Override
    public List<ProductReturnDto> productsInRange(BigDecimal lower, BigDecimal upper) {
        return productRepository.findByPriceBetweenAndBuyerIsNull(lower, upper).stream()
                .map(p -> {
                    ProductReturnDto product = modelMapper.map(p, ProductReturnDto.class);
                    product.setSeller(p.getSeller().getFirstName() + " " + p.getSeller().getLastName());
                    return product;
                })
                .sorted((p1, p2) -> {
                    if (p1.getPrice().compareTo(p2.getPrice()) == 0) {
                        return p1.getSeller().compareTo(p2.getSeller());
                    }
                    return p1.getPrice().compareTo(p2.getPrice());
                })
                .collect(Collectors.toList());
    }
}
