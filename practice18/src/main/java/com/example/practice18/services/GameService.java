package com.example.practice18.services;

import com.example.practice18.repositories.AuthorRepository;
import com.example.practice18.repositories.GameRepository;
import com.example.practice18.tables.Game;
import com.example.practice18.tables.GameAuthor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
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
