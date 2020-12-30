package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String name);

    List<Ingredient> findAllByNameIn(List<String> names);

    Ingredient getByName(String name);

    int deleteByName(String name);

    @Modifying
    void updateIngredientsByPrice();

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    void updatePrice();

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price * 1.2 WHERE i.name IN :names")
    int updateIngredientsByNames(List<String> names);
}
