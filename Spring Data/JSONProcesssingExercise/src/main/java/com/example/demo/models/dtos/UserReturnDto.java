package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserReturnDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<SoldProductDto> soldProducts;

    public UserReturnDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
