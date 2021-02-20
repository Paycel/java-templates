package task7.flyweight;

import java.util.EnumMap;
import java.util.Map;

public class PotionFactory {
    private final Map<PotionType, Potion> potions;

    public PotionFactory() {
        potions = new EnumMap<>(PotionType.class);
    }

    public Potion createPotion(PotionType type) {
        Potion potion = potions.get(type);
        if (potion == null) {
            switch (type) {
                case HEAL:
                    potion = new HealingPotion();
                    potions.put(type, potion);
                    break;
                case SPEED:
                    potion = new SpeedPotion();
                    potions.put(type, potion);
                    break;
                case STAMINA:
                    potion = new StaminaPotion();
                    potions.put(type, potion);
                    break;
                default:
                    break;
            }
        }
        return potion;
    }
}
