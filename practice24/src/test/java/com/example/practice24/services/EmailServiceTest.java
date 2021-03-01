package com.example.practice24.services;

import com.example.practice24.models.GameAuthor;
import com.example.practice24.models.Gameable;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.example.practice24.EmailInfo.email;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EmailServiceTest {
    @Autowired
    private EmailService service;

    @MockBean
    private JavaMailSender sender;

    @Captor
    ArgumentCaptor<SimpleMailMessage> captor;

    private CountDownLatch lock = new CountDownLatch(1);


    @Test
    void sendEmail() throws InterruptedException {

        GameAuthor item = new GameAuthor();
        item.setAuthor_id(1);
        item.setNickname("author");
        service.sendEmail(item);
        lock.await(2000, TimeUnit.MILLISECONDS);

        Mockito.verify(sender, times(1)).send(ArgumentMatchers.any(SimpleMailMessage.class));
        Mockito.verify(sender, times(1)).send(captor.capture());
        Assertions.assertTrue(captor.getValue().getText().contains(item.getNickname()));

    }
}