package com.example.demo.services;

import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserRegisterDto;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto user);

    String logoutUser();

    boolean isAdminLogged();
}
