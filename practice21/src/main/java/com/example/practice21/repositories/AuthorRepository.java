package com.example.practice21.repositories;

import com.example.practice21.tables.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Integer> {
}
