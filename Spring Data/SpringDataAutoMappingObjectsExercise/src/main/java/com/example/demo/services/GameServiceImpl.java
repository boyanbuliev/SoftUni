package com.example.demo.services;

import com.example.demo.dtos.AddGameDto;
import com.example.demo.dtos.DeleteGameDto;
import com.example.demo.dtos.EditGameDto;
import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import com.example.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserService userService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserService userService, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addGame(AddGameDto addGameDto) {
        if (!this.userService.isAdminLogged()) {
            return "Administrator not logged in";
        }
        StringBuilder sb = new StringBuilder();
        if (this.validatorUtil.isValid(addGameDto)) {
            Game game = this.modelMapper.map(addGameDto, Game.class);
            gameRepository.saveAndFlush(game);
            sb.append("Added ").append(game.getTitle());
        } else {
            validatorUtil.violations(addGameDto)
                    .forEach(e -> sb.append(String.format("%s%n", e.getMessage())));
        }
        return sb.toString();
    }

    @Override
    public String editGame(EditGameDto editGameDto) {
        if (!this.userService.isAdminLogged()) {
            return "Administrator not logged in";
        }
        Game game = gameRepository.getOne(editGameDto.getId());
        game = modelMapper.map(editGameDto, Game.class);
        gameRepository.saveAndFlush(game);
        System.out.println();
        return "";
    }

    @Override
    public String deleteGame(DeleteGameDto deleteGameDto) {
        if (!this.userService.isAdminLogged()) {
            return "Administrator not logged in";
        }
        StringBuilder sb = new StringBuilder();
        Optional<Game> game = gameRepository.findById(deleteGameDto.getId());
        if (game.isPresent()) {
            gameRepository.delete(game.get());
            sb.append("Deleted ").append(game.get().getTitle());
        } else {
            sb.append("Invalid id");
        }
        return sb.toString();
    }


}
