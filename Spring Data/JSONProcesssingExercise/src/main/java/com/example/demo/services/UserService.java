package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.dtos.UserReturnDto;
import com.example.demo.models.dtos.UserSeedDto;

import java.util.Set;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    User getRandomUser();

    Set<UserReturnDto> successfullySoldProducts();
}
