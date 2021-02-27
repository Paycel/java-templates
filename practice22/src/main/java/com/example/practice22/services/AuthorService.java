package com.example.practice22.services;

import com.example.practice22.repositories.AuthorRepository;
import com.example.practice22.tables.GameAuthor;
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

    public void remove(Integer id) {
        repo.deleteById(id);
    }

    public List<GameAuthor> getAuthorsOrderByDate() {
        return repo.findAll(Sort.by("birthDate"));
    }

    public List<GameAuthor> getGameOrderByName() {
        return repo.findAll(Sort.by("nickname"));
    }
}
