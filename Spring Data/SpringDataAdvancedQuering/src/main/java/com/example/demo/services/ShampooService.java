package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Label;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectShampoosBySize(Size size);

    List<Shampoo> selectShampoosBySizeOrLabel(Size size, Label label);

    List<Shampoo> selectShampoosByPrice(BigDecimal price);

    int countShampoosByPrice(BigDecimal price);

    List<Shampoo> selectShampoosByIngredients(List<Ingredient> ingredients);

    List<Shampoo> selectShampoosByIngredientsCount(int count);
}
