package com.example.practice14;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private ArrayList<Gameable> list = new ArrayList<>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    @PostMapping(value = "/create-game")
    @ResponseBody
    public void createGame(@RequestBody Game game) {
        list.add(game);
        //System.out.println(game);
    }

    @PostMapping(value = "/create-author")
    @ResponseBody
    public void createAuthor(@RequestBody GameAuthor author) {
        list.add(author);
    }

    @GetMapping(value = "/delete-game")
    @ResponseBody
    public void deleteGame(String name, String date) {
        List<Gameable> rList = new ArrayList<>();
        list.stream()
                .filter(item -> item instanceof Game)
                .map(Game.class::cast)
                .filter(game -> game.getName().equals(name) && game.getCreationDate().equals(date))
                .forEach(rList::add);
        list.removeAll(rList);
    }

    @GetMapping(value = "/delete-author")
    @ResponseBody
    public void deleteAuthor(String name, String date) {
        List<Gameable> rList = new ArrayList<>();
        list.stream()
                .filter(item -> item instanceof GameAuthor)
                .map(GameAuthor.class::cast)
                .filter(author -> author.getNickname().equals(name) && author.getBirthDate().equals(date))
                .forEach(rList::add);
        list.removeAll(rList);
    }

    @GetMapping(value = "/show-game")
    @ResponseBody
    public Object[] showGames() {
        return list.stream()
                .filter(item -> item instanceof Game).toArray();
    }

    @GetMapping(value = "/show-author")
    @ResponseBody
    public Object[] showAuthors() {
        return list.stream()
                .filter(item -> item instanceof GameAuthor).toArray();
    }

    @GetMapping(value = "/show-all")
    @ResponseBody
    public Object[] showAll() {
        return list.toArray();
    }
}
