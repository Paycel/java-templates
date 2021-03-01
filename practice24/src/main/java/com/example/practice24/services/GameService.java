package com.example.practice24.services;

import com.example.practice24.repositories.GameRepository;
import com.example.practice24.models.Game;
import com.example.practice24.models.GameAuthor;
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

    public GameAuthor getAuthorByGame(Long id) {
        return repo.findById(id).get().getAuthor();
    }

    public void save(Game value) {
        repo.save(value);
    }

    public void remove(Long id) {
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
