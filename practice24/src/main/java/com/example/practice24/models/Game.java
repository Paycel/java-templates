package com.example.practice24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "games")
@Setter
@Getter
public class Game implements Gameable{
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;

    @Column(name = "name")
    private String name;

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "creation_date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    @JsonIgnore
    private GameAuthor author;

    @Override
    public Integer getId() {
        return game_id;
    }
}
