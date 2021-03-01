package com.example.practice24.repositories;

import com.example.practice24.models.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<GameAuthor, Long> {
}
