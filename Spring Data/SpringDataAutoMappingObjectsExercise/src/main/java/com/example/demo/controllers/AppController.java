package com.example.demo.controllers;

import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.services.GameService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;

@Controller
public class AppController implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;
    private final BufferedReader reader;

    @Autowired
    public AppController(UserService userService, GameService gameService, BufferedReader reader) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] tokens = reader.readLine().split("\\|");
        switch (tokens[0]) {
            case "RegisterUser":
                UserRegisterDto user = new UserRegisterDto(tokens[1], tokens[2], tokens[3], tokens[4]);
                System.out.println(this.userService.registerUser(user));
                break;
        }
    }
}

