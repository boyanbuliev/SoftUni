package com.example.demo.services;

import com.example.demo.entities.Game;

public interface GameService {
    Game addGame(Game game);

    Game editGame(Game game);

    Game deleteGame(Game game);
}
