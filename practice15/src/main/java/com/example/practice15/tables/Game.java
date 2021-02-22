package com.example.practice15.tables;

import com.example.practice15.Gameable;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game implements Gameable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
