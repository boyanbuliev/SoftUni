package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public Game editGame(Game game) {
        return null;
    }

    @Override
    public Game deleteGame(Game game) {
        return null;
    }


}
