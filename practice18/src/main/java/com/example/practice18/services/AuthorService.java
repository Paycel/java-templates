package com.example.practice18.services;

import com.example.practice18.repositories.AuthorRepository;
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
