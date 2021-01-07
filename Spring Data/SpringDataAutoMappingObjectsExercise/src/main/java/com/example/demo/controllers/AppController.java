package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.services.GameService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        while (true) {
            String[] tokens = reader.readLine().split("\\|");
            switch (tokens[0]) {
                case "RegisterUser":
                    UserRegisterDto registerDto = new UserRegisterDto(tokens[1], tokens[2], tokens[3], tokens[4]);
                    System.out.println(this.userService.registerUser(registerDto));
                    break;
                case "LoginUser":
                    UserLoginDto loginDto = new UserLoginDto(tokens[1], tokens[2]);
                    System.out.println(this.userService.loginUser(loginDto));
                    break;
                case "Logout":
                    System.out.println(userService.logoutUser());
                    break;
                case "AddGame":
                    AddGameDto addGameDto = new AddGameDto(tokens[1], new BigDecimal(tokens[2]),
                            Double.parseDouble(tokens[3]), tokens[4], tokens[5], tokens[6],
                            LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    System.out.println(gameService.addGame(addGameDto));
                    break;
                case "EditGame":
                    EditGameDto editGameDto = new EditGameDto();
                    editGameDto.setId(1);
                    editGameDto.setTitle("Pesho");
                    gameService.editGame(editGameDto);
                    break;
                case "DeleteGame":
                    DeleteGameDto deleteGameDto = new DeleteGameDto(Long.parseLong(tokens[1]));
                    System.out.println(gameService.deleteGame(deleteGameDto));
                    break;
            }
        }
    }
}

