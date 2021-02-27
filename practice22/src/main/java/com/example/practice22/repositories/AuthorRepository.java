package com.example.practice22.repositories;

import com.example.practice22.tables.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Integer> {
}
