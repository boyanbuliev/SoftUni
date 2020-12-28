package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Label;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    @Query("SELECT s FROM Shampoo s WHERE s.brand LIKE %:brand%")
    List<Shampoo> searchByBrand(String brand);

    @Transactional
    @Modifying
    @Query("UPDATE Shampoo s SET s.price = :price WHERE s.size = :size")
    void updateShampooPriceBySize(BigDecimal price, Size size);

    @Transactional
    @Modifying
    @Query("DELETE FROM Shampoo s WHERE s.price = :price")
    void deleteShampoosByPrice(BigDecimal price);

    List<Shampoo> findAllByBrandAndSize(String brand, Size size);

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelOrderByPrice(Size size, Label label);

    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllByPriceAfterOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    List<Shampoo> findAllByIngredientsIn(List<Ingredient> ingredients);

    @Query("SELECT s FROM Shampoo s INNER JOIN s.ingredients i WHERE i IN :ingredients")
    List<Shampoo> findAllByIngredients(List<Ingredient> ingredients);

    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :count")
    List<Shampoo> findAllByIngredientsCount(int count);

    @Transactional
    @Query("SELECT s FROM Shampoo s INNER JOIN s.ingredients i WHERE i IN :ingredient")
    List<Shampoo>selectShampoosWithIngredient(Ingredient ingredient);

    @Query("SELECT count(s.id) AS count, s.size AS size FROM Shampoo s GROUP BY s.size")
    List<Object[]> groupAllShampoosBySize();
}
