package task6.factory;

import task6.Car;

public class Nissan implements Car {
    @Override
    public void run() {
        System.out.println("Run NISSAN");
    }

    @Override
    public String toString() {
        return "Nissan{}";
    }
}
