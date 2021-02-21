package com.example.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice12Application implements CommandLineRunner {
    @Autowired
    private HashGen hashGen;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Practice12Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 2) hashGen.start(args[0], args[1]);
        else hashGen.hash();
        // else standard input.txt-output.txt
    }
}
