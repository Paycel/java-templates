package com.example.practice18.repositories;

import com.example.practice18.tables.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
