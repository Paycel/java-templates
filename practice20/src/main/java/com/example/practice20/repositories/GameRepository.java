package com.example.practice20.repositories;

import com.example.practice20.tables.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
