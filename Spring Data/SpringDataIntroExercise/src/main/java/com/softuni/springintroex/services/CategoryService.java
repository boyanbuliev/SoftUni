package com.softuni.springintroex.services;

import com.softuni.springintroex.entitites.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    int getCategoriesCount();

    Category findCategoryById(long id);
}
