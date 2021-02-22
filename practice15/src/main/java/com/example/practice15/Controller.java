package com.example.practice15;

import com.example.practice15.repository.Repository;
import com.example.practice15.tables.Game;
import com.example.practice15.tables.GameAuthor;
import com.example.practice15.tables.TableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Repository repo;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    @PostMapping(value = "/create-game")
    @ResponseBody
    public void createGame(@RequestBody Game game) {
        repo.save(game);
    }

    @PostMapping(value = "/create-author")
    @ResponseBody
    public void createAuthor(@RequestBody GameAuthor author) {
        repo.save(author);
    }

    @GetMapping(value = "/delete-game")
    @ResponseBody
    public void deleteGame(Integer id) {
        repo.remove(TableType.GAME, id);
    }

    @GetMapping(value = "/delete-author")
    @ResponseBody
    public void deleteAuthor(Integer id) {
        repo.remove(TableType.AUTHOR, id);
    }

    @GetMapping(value = "/show-game")
    @ResponseBody
    public List<Gameable> showGames() {
        return repo.getGames();
    }

    @GetMapping(value = "/show-author")
    @ResponseBody
    public List<Gameable> showAuthors() {
        return repo.getAuthors();
    }

    @GetMapping(value = "/show-all")
    @ResponseBody
    public List<Gameable> showAll() {
        return repo.getAll();
    }
}
