package com.example.practice23.repositories;

import com.example.practice23.models.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Long> {
}
