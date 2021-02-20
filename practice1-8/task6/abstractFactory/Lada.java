package task6.abstractFactory;

import task6.Car;

public class Lada implements Car {
    private final String country;

    public Lada(String country) {
        this.country = country;
    }

    @Override
    public void run() {
        System.out.println("Run LADA");
    }

    @Override
    public String toString() {
        return "Lada{" +
                "country='" + country + '\'' +
                '}';
    }
}
