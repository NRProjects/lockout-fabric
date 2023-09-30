package me.marin.lockout.lockout.goals.kill.unique;

import me.marin.lockout.lockout.interfaces.KillUniqueHostileMobsGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Kill10UniqueHostileMobsGoal extends KillUniqueHostileMobsGoal {

    private final ItemStack ITEM = Items.IRON_SWORD.getDefaultStack();

    public Kill10UniqueHostileMobsGoal(String id, String data) {
        super(id, data);
        ITEM.setCount(getAmount());
    }

    @Override
    public String getGoalName() {
        return "Kill 10 Unique Hostile Mobs";
    }

    @Override
    public ItemStack getTextureItemStack() {
        return ITEM;
    }

    @Override
    public int getAmount() {
        return 10;
    }

}
