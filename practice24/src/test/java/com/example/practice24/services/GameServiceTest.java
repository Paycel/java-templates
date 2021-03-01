package com.example.practice24.services;

import com.example.practice24.models.Game;
import com.example.practice24.models.GameAuthor;
import com.example.practice24.repositories.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private AuthorService authorService;

    @MockBean
    private GameRepository gameRepository;

    @Captor
    ArgumentCaptor<Game> captor;

    @Test
    void save() {
        GameAuthor author = new GameAuthor();
        author.setAuthor_id(2);
        author.setBirthDate("bd");
        author.setNickname("name");
        authorService.save(author);
        Game game = new Game();
        game.setAuthor_id(2);
        game.setGame_id(1);
        game.setName("name1");
        game.setCreationDate("date");
        gameService.save(game);

        Mockito.verify(gameRepository, Mockito.times(1)).save(game);
        Mockito.when(gameRepository.findAll()).thenReturn(Collections.singletonList(game));
        Mockito.verify(gameRepository).save(captor.capture());
        Assertions.assertEquals(2, captor.getValue().getAuthor_id());
    }

    @Test
    void remove() {
        GameAuthor author = new GameAuthor();
        author.setAuthor_id(2);
        author.setBirthDate("bd");
        author.setNickname("name");
        authorService.save(author);
        Game game = new Game();
        game.setAuthor_id(2);
        game.setGame_id(1);
        game.setName("name1");
        game.setCreationDate("date");
        gameService.save(game);
        gameService.remove(1L);

        Mockito.verify(gameRepository, Mockito.times(1)).deleteById(1L);
        Assertions.assertTrue(gameRepository.findAll().isEmpty());
    }
}