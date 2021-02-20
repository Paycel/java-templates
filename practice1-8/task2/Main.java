package task2;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
        Вариант 7. Выбор первых 5 элементов списка, сортировка по дате рождения от
        старых к новым, фильтрация по весу меньше, чем 60, вывод имени и фамилии
        через пробел.
         */
        List<Human> list = new ArrayList<>();
        list.add(new Human(24, 76, "Alexey", "LstNm1", LocalDate.of(Year.now().getValue() - 24, 1, 1)));
        list.add(new Human(19, 78, "Galina", "LstNm2", LocalDate.of(Year.now().getValue() - 19, 5, 14)));
        list.add(new Human(41, 54, "Name", "LstNm3", LocalDate.of(Year.now().getValue() - 41, 6, 12)));
        list.add(new Human(46, 45, "Name1", "LstNm4", LocalDate.of(Year.now().getValue() - 46, 7, 21)));
        list.add(new Human(64, 92, "Buck", "LstNm5", LocalDate.of(Year.now().getValue() - 64, 8, 4)));
        list.add(new Human(14, 39, "Bob", "LstNm6", LocalDate.of(Year.now().getValue() - 14, 9, 15)));
        list.add(new Human(83, 59, "Joe", "LstNm7", LocalDate.of(Year.now().getValue() - 83, 10, 25)));
        list.add(new Human(54, 73, "Nika", "LstNm8", LocalDate.of(Year.now().getValue() - 54, 11, 30)));
        list.add(new Human(31, 62, "Garold", "LstNm9", LocalDate.of(Year.now().getValue() - 31, 12, 28)));
        list.add(new Human(35, 59, "Andrey", "LstNm1", LocalDate.of(Year.now().getValue() - 35, 3, 3)));
        System.out.println("Первые 5 элементов:");
        list.stream().limit(5).forEach(System.out::println);
        System.out.println("Сортировка по дате рождения от старых к новым:");
        list.stream().sorted((Comparator.comparing(Human::getBirthDate))).forEach(System.out::println);
        System.out.println("Фильтрация по весу меньше 60:");
        list.stream().filter((human -> human.getWeight() < 60)).forEach(System.out::println);
        System.out.println("Вывод имени и фамилии");
        list.forEach(human -> System.out.println(human.getFirstName() + " " + human.getLastName()));
    }
}
