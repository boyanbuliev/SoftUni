package com.example.demo.services.impl;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.models.dtos.SoldProductDto;
import com.example.demo.models.dtos.UserReturnDto;
import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository, ProductRepository productRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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

    @Override
    public Set<UserReturnDto> successfullySoldProducts() {
        return userRepository.findBySoldProducts().stream()
                .map(u -> {
                    UserReturnDto user = modelMapper.map(u, UserReturnDto.class);
                    List<Product> allBySellerAndBuyerIsNotNull = productRepository.findAllBySellerAndBuyerIsNotNull(u);
                    user.setSoldProducts(allBySellerAndBuyerIsNotNull.stream()
                            .map(p -> modelMapper.map(p, SoldProductDto.class)).collect(Collectors.toSet()));
                    return user;
                }).collect(Collectors.toSet());
    }
}
