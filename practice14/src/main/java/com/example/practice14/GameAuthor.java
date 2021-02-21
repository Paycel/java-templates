package com.example.practice14;

public class GameAuthor implements Gameable{
    private final String nickname, birthDate;

    public GameAuthor(String nickname, String birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "GameAuthor{" +
                "nickname='" + nickname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
