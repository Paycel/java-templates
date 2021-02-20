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

    /*
    Создать приложение, в котором создается ApplicationContext и из него берётся бин с названием,
    переданным в качестве аргумента к приложению, и вызывается метод интерфейса, который он имплементирует.
    Нужно создать по одному бину для каждого класса, определить им название.
    Проверить, что вызывается при вводе названия каждого из бинов.
    Классы и интерфейс определяются в соответствии с вариантом индивидуального задания.

    Интерфейс Musician с методом doCoding(), его имплементации: Drummer, guitarist, trombonist.
     */

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
