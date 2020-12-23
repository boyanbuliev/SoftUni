package entities.shampoos;

import entities.ingredients.BasicIngredient;
import entities.labels.BasicLabel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shampoo")
public abstract class BasicShampoo implements Shampoo {
    @Id
    @GeneratedValue
    private long id;
    private BigDecimal price;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Size size;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<BasicIngredient> ingredients;
    @OneToOne(cascade = CascadeType.ALL)
    private BasicLabel label;


    public BasicShampoo() {
        this.ingredients = new HashSet<>();
    }

    public BasicShampoo(String brand, BigDecimal price, Size size, BasicLabel label) {
        this();
        this.price = price;
        this.brand = brand;
        this.size = size;
        this.label = label;
    }

    @Override
    public BasicLabel getLabel() {
        return label;
    }

    public void setLabel(BasicLabel label) {
        this.label = label;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
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
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
