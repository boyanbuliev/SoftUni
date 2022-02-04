package com.softuni.judge.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Length(min = 2, message = "Username length must be minimum two characters")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, message = "Password length must be minimum three characters")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
