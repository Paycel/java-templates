package com.example.practice24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Practice24Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice24Application.class, args);
    }
}
