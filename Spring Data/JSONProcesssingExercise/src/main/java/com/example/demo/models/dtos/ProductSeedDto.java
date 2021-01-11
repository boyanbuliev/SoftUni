package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    @Length(min = 3)
    private String name;
    @Expose
    @Positive
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
