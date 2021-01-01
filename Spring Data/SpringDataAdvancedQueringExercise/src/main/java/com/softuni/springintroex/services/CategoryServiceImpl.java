package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Category;
import com.softuni.springintroex.repositories.CategoryRepository;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;

import static com.softuni.springintroex.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(CATEGORIES_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            Category category = new Category(r);
            this.categoryRepository.saveAndFlush(category);
        });
    }

    @Override
    public int getCategoriesCount() {
        return (int) this.categoryRepository.count();
    }

    @Override
    public Category findCategoryById(long id) {
        return this.categoryRepository.getOne(id);
    }
}
