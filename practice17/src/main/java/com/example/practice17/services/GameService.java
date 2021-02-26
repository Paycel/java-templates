package com.example.practice17.services;

import com.example.practice17.tables.Game;
import com.example.practice17.tables.GameAuthor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private final SessionFactory factory;
    private Session session;

    public GameService(SessionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    private void init() {
        session = factory.openSession();
    }

    public List<Game> getGames() {
        return session.createQuery("FROM Game").getResultList();
    }

    public GameAuthor getAuthorByGame(Integer id) {
        return session.createQuery("FROM Game WHERE game_id = :id", Game.class)
                .setParameter("id", id).setMaxResults(1).uniqueResult().getAuthor();
    }

    public void save(Game value) {
        session.beginTransaction();
        if (value.getGame_id() == null)
            session.persist(value);
        else
            session.merge(value);
        session.getTransaction().commit();

    }

    public void remove(Integer id) {
        session.beginTransaction();
        Game item = session.find(Game.class, id);
        if (item != null) {
            session.remove(item);
        }
        session.getTransaction().commit();
    }

    public List<Game> getGameOrderByAuthorId() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> gameCriteriaQuery = builder.createQuery(Game.class);
        Root<Game> root = gameCriteriaQuery.from(Game.class);
        gameCriteriaQuery.select(root).orderBy(builder.asc(root.get("author_id")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    public List<Game> getGameOrderByName() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> gameCriteriaQuery = builder.createQuery(Game.class);
        Root<Game> root = gameCriteriaQuery.from(Game.class);
        gameCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    public List<Game> getGameOrderByDate() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> gameCriteriaQuery = builder.createQuery(Game.class);
        Root<Game> root = gameCriteriaQuery.from(Game.class);
        gameCriteriaQuery.select(root).orderBy(builder.asc(root.get("creationDate")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    private void finish() {
        session.close();
    }
}
