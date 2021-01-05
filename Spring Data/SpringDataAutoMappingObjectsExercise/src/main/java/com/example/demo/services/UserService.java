package com.example.demo.services;

import com.example.demo.dtos.UserRegisterDto;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    void loginUser();

    void logoutUser();
}
