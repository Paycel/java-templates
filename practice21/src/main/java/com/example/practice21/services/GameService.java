package com.example.practice21.services;

import com.example.practice21.repositories.GameRepository;
import com.example.practice21.tables.Game;
import com.example.practice21.tables.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class GameService {
    private GameRepository repo;

    public GameService(GameRepository repo) {
        this.repo = repo;
    }

    public List<Game> getGames() {
        return repo.findAll();
    }

    public GameAuthor getAuthorByGame(Integer id) {
        return repo.findById(id).get().getAuthor();
    }

    public void save(Game value) {
        repo.save(value);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }

    public List<Game> getGameOrderByAuthorId() {
        return repo.findAll(Sort.by("author_id"));
    }

    public List<Game> getGameOrderByName() {
        return repo.findAll(Sort.by("name"));
    }

    public List<Game> getGameOrderByDate() {
        return repo.findAll(Sort.by("creationDate"));
    }
}
