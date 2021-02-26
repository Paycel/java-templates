package com.example.practice21.repositories;

import com.example.practice21.tables.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
