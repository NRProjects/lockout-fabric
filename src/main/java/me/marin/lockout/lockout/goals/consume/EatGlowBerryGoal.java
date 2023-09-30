package me.marin.lockout.lockout.goals.consume;

import me.marin.lockout.lockout.interfaces.ConsumeItemGoal;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class EatGlowBerryGoal extends ConsumeItemGoal {

    public EatGlowBerryGoal(String id, String data) {
        super(id, data);
    }

    @Override
    public String getGoalName() {
        return "Eat a Glow Berry";
    }

    @Override
    public Item getItem() {
        return Items.GLOW_BERRIES;
    }

}
