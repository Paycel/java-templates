package task7.flyweight;

public class SpeedPotion implements Potion{
    @Override
    public void use() {
        System.out.println("Use speed potion; this = " + this);
    }
}
