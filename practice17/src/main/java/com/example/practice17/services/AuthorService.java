package com.example.practice17.services;

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
        return session.createQuery("FROM GameAuthor ").getResultList();
    }

    public void save(GameAuthor value) {
        session.beginTransaction();
        if (value.getAuthor_id() == null)
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

    public List<GameAuthor> getAuthorsOrderByDate() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GameAuthor> authorCriteriaQuery = builder.createQuery(GameAuthor.class);
        Root<GameAuthor> root = authorCriteriaQuery.from(GameAuthor.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("birthDate")));
        Query<GameAuthor> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }

    public List<GameAuthor> getGameOrderByName() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GameAuthor> authorCriteriaQuery = builder.createQuery(GameAuthor.class);
        Root<GameAuthor> root = authorCriteriaQuery.from(GameAuthor.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("nickname")));
        Query<GameAuthor> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }
}
