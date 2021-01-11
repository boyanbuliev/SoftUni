package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class CategorySeedDto {
    @Expose
    @Length(min = 3, max = 15,message = "Wrong category name length")
    private String name;

    public CategorySeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
