package com.example.demo.components;

import com.example.demo.Musician;
import org.springframework.stereotype.Component;

@Component
public class Trombonist implements Musician {
    @Override
    public void doCoding() {
        System.out.println("Trombonist is coding");
    }
}
