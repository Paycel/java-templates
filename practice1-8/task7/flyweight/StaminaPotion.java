package task7.flyweight;

public class StaminaPotion implements Potion{
    @Override
    public void use() {
        System.out.println("Use Stamina Potion; this = " + this);
    }
}
