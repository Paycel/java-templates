package com.example.practice19.services;

import com.example.practice19.repositories.AuthorRepository;
import com.example.practice19.tables.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {

    private AuthorRepository repo;

    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<GameAuthor> getAuthors() {
        log.info("Returning GameAuthor list");
        return repo.findAll();
    }

    public void save(GameAuthor value) {
        log.info("Saving GameAuthor with name " + value.getNickname());
        repo.save(value);
    }

    public void remove(Integer id) {
        log.info("Deleting GameAuthor with id " + id);
        repo.deleteById(id);
    }

    public List<GameAuthor> getAuthorsOrderByDate() {
        log.info("Returning GameAuthor List sorted by date");
        return repo.findAll(Sort.by("birthDate"));
    }

    public List<GameAuthor> getGameOrderByName() {
        log.info("Returning GameAuthor List sorted by name");
        return repo.findAll(Sort.by("nickname"));
    }
}
