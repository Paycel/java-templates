package com.example.practice21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Practice21Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice21Application.class, args);
    }

}
