package com.example.practice19.services;

import com.example.practice19.repositories.GameRepository;
import com.example.practice19.tables.Game;
import com.example.practice19.tables.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GameService {
    private GameRepository repo;

    public GameService(GameRepository repo) {
        this.repo = repo;
    }

    public List<Game> getGames() {
        return repo.findAll();
    }

    public GameAuthor getAuthorByGame(Integer id) {
        log.info("Returning GameAuthor for Game with id " + id);
        return repo.findById(id).get().getAuthor();
    }

    public void save(Game value) {
        log.info("Saving Game with name " + value.getName());
        repo.save(value);
    }

    public void remove(Integer id) {
        log.info("Deleting Game with id " + id);
        repo.deleteById(id);
    }

    public List<Game> getGameOrderByAuthorId() {
        log.info("Returning Game List sorted by author_id");
        return repo.findAll(Sort.by("author_id"));
    }

    public List<Game> getGameOrderByName() {
        log.info("Returning Game List sorted by name");
        return repo.findAll(Sort.by("name"));
    }

    public List<Game> getGameOrderByDate() {
        log.info("Returning Game List sorted by creation_date");
        return repo.findAll(Sort.by("creationDate"));
    }
}
