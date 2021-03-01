package com.example.practice24.controller;

import com.example.practice24.services.AuthorService;
import com.example.practice24.services.GameService;
import com.example.practice24.models.Game;
import com.example.practice24.models.GameAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    @PostMapping(value = "/create-game")
    @ResponseBody
    public void createGame(@RequestBody Game game) {
        gameService.save(game);
    }

    @PostMapping(value = "/create-author")
    @ResponseBody
    public void createAuthor(@RequestBody GameAuthor author) {
        authorService.save(author);
    }

    @GetMapping(value = "/delete-game")
    @ResponseBody
    public void deleteGame(Long id) {
        gameService.remove(id);
    }

    @GetMapping(value = "/delete-author")
    @ResponseBody
    public void deleteAuthor(Long id) {
        authorService.remove(id);
    }

    @GetMapping(value = "/show-game")
    @ResponseBody
    public List<Game> showGames() {
        return gameService.getGames();
    }

    @GetMapping(value = "/show-author")
    @ResponseBody
    public List<GameAuthor> showAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(value = "/game/{id}/author")
    @ResponseBody
    public GameAuthor getGameAuthor(@PathVariable("id") Long id){
        return gameService.getAuthorByGame(id);
    }

    @GetMapping(value = "/show-author-orderBy-date")
    @ResponseBody
    public List<GameAuthor> showAuthorsOrderByDate() {
        return authorService.getAuthorsOrderByDate();
    }

    @GetMapping(value = "/show-author-orderBy-name")
    @ResponseBody
    public List<GameAuthor> showAuthorsOrderByName() {
        return authorService.getGameOrderByName();
    }

    @GetMapping(value = "/show-game-orderBy-authorId")
    @ResponseBody
    public List<Game> showGameOrderByAuthorId() {
        return gameService.getGameOrderByAuthorId();
    }

    @GetMapping(value = "/show-game-orderBy-name")
    @ResponseBody
    public List<Game> showGameOrderByName() {
        return gameService.getGameOrderByName();
    }

    @GetMapping(value = "/show-game-orderBy-date")
    @ResponseBody
    public List<Game> showGameOrderByDate() {
        return gameService.getGameOrderByDate();
    }
}
