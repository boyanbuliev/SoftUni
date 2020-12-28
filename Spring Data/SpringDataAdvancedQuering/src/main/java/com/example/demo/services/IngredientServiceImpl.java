package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectIngredientsByName(String name) {
        return this.ingredientRepository.findAllByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> selectIngredientsByNames(List<String> names) {
        return this.ingredientRepository.findAllByNameIn(names);
    }

    @Override
    public Ingredient findByName(String name) {
        return this.ingredientRepository.getByName(name);
    }

    @Override
    public int deleteIngredientsByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }
}
