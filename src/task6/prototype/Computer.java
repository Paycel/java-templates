package task6.prototype;

public class Computer implements Cloneable<Computer>{
    private String SSD, HDD;

    public Computer(String SSD, String HDD) {
        this.SSD = SSD;
        this.HDD = HDD;
    }

    @Override
    public Computer clone() {
        return new Computer(SSD, HDD);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "SSD='" + SSD + '\'' +
                ", HDD='" + HDD + '\'' +
                '}';
    }
}
