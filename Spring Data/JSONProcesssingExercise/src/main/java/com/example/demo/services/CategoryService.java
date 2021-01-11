package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.models.dtos.CategorySeedDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] dtos);

    List<Category> getCategories();
}
