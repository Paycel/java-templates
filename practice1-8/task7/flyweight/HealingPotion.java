package task7.flyweight;

public class HealingPotion implements Potion{
    @Override
    public void use() {
        System.out.println("Use Heal Potion; this = " + this);
    }
}
