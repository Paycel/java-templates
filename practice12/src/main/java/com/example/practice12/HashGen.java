package com.example.practice12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class HashGen {
    @Value("${input:input.txt}")
    private String input;
    @Value("${output:output.txt}")
    private String output;
    private File fileInput, fileOutput;

    public HashGen() {
        System.out.println("Constructor run");
    }

    @PostConstruct
    private void init() {
        System.out.println("Preparing files..");
        fileInput = new File(input);
        fileOutput = new File(output);
        System.out.println("Files prepared");
    }

    public void hash() {
        System.out.println("Start hashing..");
        if (fileInput.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                String content = new String(Files.readAllBytes(Paths.get(input)));
                writer.write(DigestUtils.md5DigestAsHex(content.getBytes()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                writer.write("null");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complete");
    }

    public void start(String input, String output) {
        this.input = input;
        this.output = output;
        init();
        hash();
    }

    @PreDestroy
    private void finish() {
        System.out.println("Deleting input file..");
        fileInput.delete();
        System.out.println("Complete");
    }
}
