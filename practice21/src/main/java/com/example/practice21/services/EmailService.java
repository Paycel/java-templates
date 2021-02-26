package com.example.practice21.services;

import com.example.practice21.tables.Gameable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    private final String email;

    @Autowired
    public EmailService(@Qualifier("email") String email) {
        this.email = email;
    }

    @Async
    public void sendEmail(Gameable item) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Item insert in DB");
        message.setText("Item {id = " + item.getId() + ", name = " + item.getName() + "} inserted");
        this.emailSender.send(message);
        log.info("Email send");
    }
}
