package task6;

import task6.abstractFactory.EnFactory;
import task6.abstractFactory.MachineFactory;
import task6.abstractFactory.RuFactory;
import task6.factory.Factory;

public class Main {
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
    }
}
