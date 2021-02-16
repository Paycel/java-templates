package task6;

import task6.abstractFactory.EnFactory;
import task6.abstractFactory.MachineFactory;
import task6.abstractFactory.RuFactory;
import task6.builder.Human;
import task6.factory.Factory;
import task6.prototype.Computer;

public class Main {
    /*
    Написать реализацию паттернов «Фабричный метод», «Абстрактная
    фабрика», «Строитель», «Прототип»
     */
    public static void main(String[] args) {
        Car nissan = Factory.getCar(CarEnum.NISSAN);
        Car audi = Factory.getCar(CarEnum.AUDI);
        System.out.println(nissan + " " + audi);

        MachineFactory ruFactory = new RuFactory();
        MachineFactory enFactory = new EnFactory();
        Car ruLada = ruFactory.getLada();
        Car ruFerrari = ruFactory.getFerrari();
        Car enLada = enFactory.getLada();
        Car enFerrari = enFactory.getFerrari();
        System.out.println(ruLada + " " + ruFerrari + " " + enLada + " " + enFerrari);

        Human human = new Human.Builder("lastName").setAge(12).setFirstName("fn").build();
        System.out.println(human);

        Computer computer = new Computer("SSD", "HDD");
        System.out.println(computer.clone());
    }
}
