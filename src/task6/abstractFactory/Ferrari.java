package task6.abstractFactory;

import task6.Car;

public class Ferrari implements Car {
    private final String country;

    public Ferrari(String country) {
        this.country = country;
    }

    @Override
    public void run() {
        System.out.println("Run FERRARI");
    }

    @Override
    public String toString() {
        return "Ferrari{" +
                "country='" + country + '\'' +
                '}';
    }
}
