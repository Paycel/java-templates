package com.example.practice22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Practice22Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice22Application.class, args);
    }
}
