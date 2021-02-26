package com.example.practice20.repositories;

import com.example.practice20.tables.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Integer> {
}
