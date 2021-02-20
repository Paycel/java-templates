package task6.factory;

import task6.Car;
import task6.CarEnum;

public class Factory{
    public static Car getCar(CarEnum car){
        return car.equals(CarEnum.NISSAN) ? new Nissan() : new Audi();
    }
}
