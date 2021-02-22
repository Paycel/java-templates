package com.example.practice15.services;

import com.example.practice15.tables.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    public void save(Game value) {
        session.beginTransaction();
        if (value.getId() == null)
            session.persist(value);
        else
            session.merge(value);
        session.getTransaction().commit();

    }

    public void remove(Integer id) {
        session.beginTransaction();
        Game item = session.find(Game.class, id);
        if (item != null) session.remove(item);
        session.getTransaction().commit();
    }

    @PreDestroy
    private void finish() {
        session.close();
    }
}
