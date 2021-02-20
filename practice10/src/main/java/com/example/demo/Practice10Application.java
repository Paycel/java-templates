package com.example.demo;

import com.example.demo.components.Drummer;
import com.example.demo.components.Guitarist;
import com.example.demo.components.Trombonist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice10Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice10Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Musician musician1 = context.getBean(Drummer.class);
        Musician musician2 = context.getBean(Trombonist.class);
        Musician musician3 = context.getBean(Guitarist.class);
        musician1.doCoding();
        musician2.doCoding();
        musician3.doCoding();
    }
}
