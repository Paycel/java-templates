package com.example.practice16;

import com.example.practice16.services.AuthorService;
import com.example.practice16.services.GameService;
import com.example.practice16.tables.Game;
import com.example.practice16.tables.GameAuthor;
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
    public void createGame(Integer authorId, @RequestBody Game game) {
        gameService.save(game, authorId);
    }

    @PostMapping(value = "/create-author")
    @ResponseBody
    public void createAuthor(@RequestBody GameAuthor author) {
        authorService.save(author);
    }

    @GetMapping(value = "/delete-game")
    @ResponseBody
    public void deleteGame(Integer id) {
        gameService.remove(id);
    }

    @GetMapping(value = "/delete-author")
    @ResponseBody
    public void deleteAuthor(Integer id) {
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
    public GameAuthor getGameAuthor(@PathVariable("id") Integer id){
        return gameService.getAuthorByGame(id);
    }
}
