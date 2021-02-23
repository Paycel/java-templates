package com.example.practice16.services;

import com.example.practice16.tables.Game;
import com.example.practice16.tables.GameAuthor;
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
    @Autowired
    private AuthorService authorService;
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
        return session.createQuery("FROM Game WHERE id = :id", Game.class)
                .setParameter("id", id).getSingleResult().getAuthor();
    }

    public void save(Game value, Integer authorId) {
        session.beginTransaction();
        System.out.println(value);
        try {
            value.setAuthor(authorService.getAuthors().stream()
                    .filter(t -> t.getId().equals(authorId))
                    .findFirst()
                    .get()
            );
            if (value.getId() == null)
                session.persist(value);
            else
                session.merge(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
        }
    }

    public void remove(Integer id) {
        session.beginTransaction();
        Game item = session.find(Game.class, id);
        try {
            if (item != null) {
                item.getAuthor().getGames().remove(item);
                session.remove(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
        }
    }

    @PreDestroy
    private void finish() {
        session.close();
    }
}
