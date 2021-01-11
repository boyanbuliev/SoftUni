package com.example.demo.services.impl;

import com.example.demo.entities.User;
import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        if (userRepository.count() != 0) {
            return;
        }
        Arrays.stream(userSeedDtos).forEach(d -> {
            if (validationUtil.isValid(d)) {
                userRepository.save(modelMapper.map(d, User.class));
            } else {
                validationUtil.violations(d).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            }
        });
    }

    @Override
    public User getRandomUser() {
        return this.userRepository.getOne(ThreadLocalRandom.current().nextLong(userRepository.count()) + 1);
    }
}
