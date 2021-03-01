package com.example.practice24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SchedulerServiceTest {
    @Autowired
    private SchedulerService service;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GameService gameService;


    @Test
    void doTask() throws IOException, InterruptedException {
        service.doTask();
        File dir_game = ResourceUtils.getFile("src/main/resources/output/game_data.txt");
        File dir_author = ResourceUtils.getFile("src/main/resources/output/authors_data.txt");

        Mockito.verify(authorService, Mockito.times(1)).getAuthors();
        Mockito.verify(gameService, Mockito.times(1)).getGames();
        Assertions.assertTrue(dir_author.exists());
        Assertions.assertTrue(dir_game.exists());

    }
}