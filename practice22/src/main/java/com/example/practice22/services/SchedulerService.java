package com.example.practice22.services;

import com.example.practice22.Practice22Application;
import com.example.practice22.tables.Game;
import com.example.practice22.tables.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource(description = "Scheduler service bean")
public class SchedulerService {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GameService gameService;

    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation(description = "Clear output, create .txt with database data")
    public void doTask() throws IOException {
        log.info("Task started");
        File file_dir = ResourceUtils.getFile("src/main/resources/output");
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) file.delete();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        log.info("Files deleted");
        BufferedWriter game = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath() + "/game_data.txt"));
        BufferedWriter authors = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath() + "/authors_data.txt"));
        game.write("id\tauthor_id\tname\tcreation date\n");
        for (Game item : gameService.getGames())
            game.write(String.format("%d\t%d\t%s\t%s\n", item.getId(), item.getAuthor_id(), item.getName(), item.getCreationDate()));
        game.close();
        authors.write("id\tnickname\tbirth date\n");
        for (GameAuthor item : authorService.getAuthors())
            authors.write(String.format("%d\t%s\t%s\n", item.getId(), item.getAuthor_id(), item.getName()));
        authors.close();
    }
}
