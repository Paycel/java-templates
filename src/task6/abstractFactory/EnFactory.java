package task6.abstractFactory;

public class EnFactory extends MachineFactory{
    @Override
    public Ferrari getFerrari() {
        return new Ferrari("En");
    }

    @Override
    public Lada getLada() {
        return new Lada("En");
    }
}
