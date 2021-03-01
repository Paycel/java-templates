package com.example.practice24.services;

import com.example.practice24.repositories.AuthorRepository;
import com.example.practice24.models.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class AuthorService {

    private AuthorRepository repo;

    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<GameAuthor> getAuthors() {
        return repo.findAll();
    }

    public void save(GameAuthor value) {
        repo.save(value);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }

    public List<GameAuthor> getAuthorsOrderByDate() {
        return repo.findAll(Sort.by("birthDate"));
    }

    public List<GameAuthor> getGameOrderByName() {
        return repo.findAll(Sort.by("nickname"));
    }
}
