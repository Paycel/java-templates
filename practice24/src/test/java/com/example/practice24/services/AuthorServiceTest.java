package com.example.practice24.services;

import com.example.practice24.models.GameAuthor;
import com.example.practice24.repositories.AuthorRepository;
import org.hamcrest.CoreMatchers;
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
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @Captor
    ArgumentCaptor<GameAuthor> captor;

    @Test
    void save() {
        GameAuthor author = new GameAuthor();
        author.setAuthor_id(2);
        author.setBirthDate("bd");
        author.setNickname("name");
        authorService.save(author);
        Mockito.verify(authorRepository, Mockito.times(1)).save(author);
        Mockito.when(authorRepository.findAll()).thenReturn(Collections.singletonList(author));
        Mockito.verify(authorRepository).save(captor.capture());
        Assertions.assertEquals(2, captor.getValue().getAuthor_id());
    }

    @Test
    void remove() {
        GameAuthor author = new GameAuthor();
        author.setAuthor_id(2);
        author.setBirthDate("bd");
        author.setNickname("name");
        authorService.save(author);
        authorService.remove(2L);
        Mockito.verify(authorRepository, Mockito.times(1)).deleteById(2L);
        Assertions.assertTrue(authorRepository.findAll().isEmpty());
    }
}