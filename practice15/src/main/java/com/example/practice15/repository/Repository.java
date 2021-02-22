package com.example.practice15.repository;

import com.example.practice15.Gameable;
import com.example.practice15.tables.Game;
import com.example.practice15.tables.GameAuthor;
import com.example.practice15.tables.TableType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
@Transactional
public class Repository {

    @PersistenceContext
    private EntityManager manager;

    public List<Gameable> getAll() {
        return Stream.concat(
                manager.createQuery("FROM Game", Gameable.class).getResultList().stream(),
                manager.createQuery("FROM GameAuthor", Gameable.class).getResultList().stream())
                .collect(Collectors.toList());
    }

    public List<Gameable> getGames() {
        return manager.createQuery("FROM Game", Gameable.class).getResultList();
    }

    public List<Gameable> getAuthors() {
        return manager.createQuery("FROM GameAuthor", Gameable.class).getResultList();
    }

    public void save(Gameable value) {
        if (value.getId() == null)
            manager.persist(value);
        else
            manager.merge(value);

    }

    public void remove(TableType type, Integer id) {
        Gameable item = null;
        switch (type) {
            case AUTHOR:
                item = manager.find(GameAuthor.class, id);
                break;
            case GAME:
                item = manager.find(Game.class, id);
        }
        if (item != null) manager.remove(item);
    }
}
