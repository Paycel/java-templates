package task6.abstractFactory;

public class RuFactory extends MachineFactory{
    @Override
    public Ferrari getFerrari() {
        return new Ferrari("Ru");
    }

    @Override
    public Lada getLada() {
        return new Lada("Ru");
    }
}
