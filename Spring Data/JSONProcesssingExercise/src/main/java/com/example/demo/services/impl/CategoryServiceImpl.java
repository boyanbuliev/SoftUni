package com.example.demo.services.impl;

import com.example.demo.entities.Category;
import com.example.demo.models.dtos.CategorySeedDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(CategorySeedDto[] dtos) {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(dtos).forEach(d -> {
            if (validationUtil.isValid(d)) {
                categoryRepository.save(modelMapper.map(d, Category.class));
            } else {
                validationUtil.violations(d).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });

    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            categories.add(categoryRepository
                    .getOne((random.nextInt((int) categoryRepository.count()) + 1L)));
        }
        return categories;
    }

}
