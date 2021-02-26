package com.example.practice19.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GameAuthor {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Game> games;
}
