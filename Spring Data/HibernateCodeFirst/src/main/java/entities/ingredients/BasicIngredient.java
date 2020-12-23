package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public abstract class BasicIngredient implements Ingredient {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private BigDecimal price;
    @ManyToMany(targetEntity = BasicShampoo.class, mappedBy = "ingredients")
    private List<BasicShampoo> shampoos;

    public BasicIngredient() {
    }

    public BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public List<BasicShampoo> getShampoos() {
        return null;
    }

    @Override
    public void setShampoos(List<BasicShampoo> shampoos) {

    }
}
