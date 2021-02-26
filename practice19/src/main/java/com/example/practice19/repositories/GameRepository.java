package com.example.practice19.repositories;

import com.example.practice19.tables.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
