package com.example.practice14;

public class Game implements Gameable{
    private final String name, creationDate;

    public Game(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
