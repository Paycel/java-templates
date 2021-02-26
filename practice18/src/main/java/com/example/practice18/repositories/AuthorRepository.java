package com.example.practice18.repositories;

import com.example.practice18.tables.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Integer> {
}
