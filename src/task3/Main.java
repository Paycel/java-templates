package task3;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set1 = new SetSem<>();
        List<Integer> set2 = new ListSync<>();
        System.out.println("Start testing set1");
        test(set1);
        System.out.println("Start testing set2");
        test(set2);
    }

    public static void test(Collection<Integer> c) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 started for set " + (c instanceof SetSem ? 1 : 2));
            for (int i = 0; i < 100; i++) c.add(i);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 started for set " + (c instanceof SetSem ? 1 : 2));
            for (int i = 100; i < 200; i++) c.add(i);
        });
        thread1.start();
        thread2.start();
        Thread.sleep(5000);
        c.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
