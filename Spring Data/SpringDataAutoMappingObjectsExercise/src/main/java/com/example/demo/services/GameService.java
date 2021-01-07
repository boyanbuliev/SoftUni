package com.example.demo.services;

import com.example.demo.dtos.AddGameDto;
import com.example.demo.dtos.DeleteGameDto;
import com.example.demo.dtos.EditGameDto;

public interface GameService {
    String addGame(AddGameDto addGameDto);

    String editGame(EditGameDto editGameDto);

    String deleteGame(DeleteGameDto deleteGameDto);
}
