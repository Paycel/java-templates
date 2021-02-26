package com.example.practice19.repositories;

import com.example.practice19.tables.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Integer> {
}
