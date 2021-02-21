package com.example.practice14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice14Application {

    /*
    Создать отдельный репозиторий Git. Создать простой html-документ, который будет содержать вашу фамилию,
    имя, номер группы, номер варианта. Создать контроллер, который будет возвращать данный статический документ
    при переходе на url «/home». Выполнить задание в зависимости с вариантом индивидуального задания.

    Создать класс Game с полями name, creationDate. Создать класс GameAuthor с полями nickname, birthDate.
    Создать классы-контроллеры для создания, удаления объектов и получения всех объектов каждого типа.
    Сами объекты хранить в памяти.
     */

    public static void main(String[] args) {
        SpringApplication.run(Practice14Application.class, args);
    }

}
