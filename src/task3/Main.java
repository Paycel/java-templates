package task3;

public class Main {
    static volatile int buf;

    static void increment() {
        buf++;
    }

    public static void main(String[] args) {
        buf = 0;
        Thread one = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
                System.out.println(buf);
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
                System.out.println(buf);

            }
        });

        one.start();
        two.start();
    }
}
