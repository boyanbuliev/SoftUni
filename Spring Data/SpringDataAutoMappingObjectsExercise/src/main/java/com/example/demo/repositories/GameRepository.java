package com.example.demo.repositories;

import com.example.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Override
    List<Game> findAllById(Iterable<Long> iterable);
}
