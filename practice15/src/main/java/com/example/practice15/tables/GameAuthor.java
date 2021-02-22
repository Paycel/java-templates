package com.example.practice15.tables;

import com.example.practice15.Gameable;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class GameAuthor implements Gameable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birth_date")
    private String birthDate;

    @Override
    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "GameAuthor{" +
                "nickname='" + nickname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
