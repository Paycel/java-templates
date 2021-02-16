package task6.factory;

import task6.Car;

public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Run AUDI");
    }

    @Override
    public String toString() {
        return "Audi{}";
    }
}
