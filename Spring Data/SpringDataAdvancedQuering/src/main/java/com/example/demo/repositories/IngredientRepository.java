package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String name);

    List<Ingredient> findAllByNameIn(List<String> names);

    Ingredient getByName(String name);

    @Transactional
    int deleteByName(String name);
}
