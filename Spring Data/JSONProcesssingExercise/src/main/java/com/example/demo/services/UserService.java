package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.dtos.UserSeedDto;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    User getRandomUser();
}
