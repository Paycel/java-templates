package com.example.practice16.services;

import com.example.practice16.tables.GameAuthor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private final SessionFactory factory;
    private Session session;

    public AuthorService(SessionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    private void init() {
        session = factory.openSession();
    }

    public List<GameAuthor> getAuthors() {
        return session.createQuery("FROM GameAuthor").getResultList();
    }

    public void save(GameAuthor value) {
        session.beginTransaction();
        if (value.getId() == null)
            session.persist(value);
        else
            session.merge(value);
        session.getTransaction().commit();

    }

    public void remove(Integer id) {
        session.beginTransaction();
        GameAuthor item = session.find(GameAuthor.class, id);
        if (item != null) session.remove(item);
        session.getTransaction().commit();
    }

    @PreDestroy
    private void finish() {
        session.close();
    }
}
