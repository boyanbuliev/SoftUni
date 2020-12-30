package com.example.demo.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = "Ingredient.updateIngredientsByPrice",
        query = "UPDATE Ingredient i SET i.price = i.price * 1.1")
public class Ingredient {
    public static final String updateIngredientsByPrice="Ingredient.updateIngredientsByPrice";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private BigDecimal price;
    @ToString.Exclude
    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos = new HashSet<>();
}
