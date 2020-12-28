package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientService {
    List<Ingredient>selectIngredientsByName(String name);

    List<Ingredient>selectIngredientsByNames(List<String>names);

    Ingredient findByName(String name);

    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    int deleteIngredientsByName(String name);
}
