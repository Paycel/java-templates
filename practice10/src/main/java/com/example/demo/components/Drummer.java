package com.example.demo.components;

import com.example.demo.Musician;
import org.springframework.stereotype.Component;

@Component
public class Drummer implements Musician {
    @Override
    public void doCoding() {
        System.out.println("Drummer is coding");
    }
}
