package com.example.practice23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Practice23Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice23Application.class, args);
    }
}
