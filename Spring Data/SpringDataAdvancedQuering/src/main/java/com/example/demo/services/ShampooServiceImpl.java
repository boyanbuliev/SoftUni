package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Label;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import com.example.demo.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectShampoosBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectShampoosBySizeOrLabel(Size size, Label label) {
        return this.shampooRepository.findAllBySizeOrLabelOrderByPrice(size, label);
    }

    @Override
    public List<Shampoo> selectShampoosByPrice(BigDecimal price) {
        return this.shampooRepository.findAllByPriceAfterOrderByPriceDesc(price);
    }

    @Override
    public int countShampoosByPrice(BigDecimal price) {
        return this.shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredients(List<Ingredient> ingredients) {
        return this.shampooRepository.findAllByIngredients(ingredients);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredientsCount(int count) {
        return this.shampooRepository.findAllByIngredientsCount(count);
    }
}
