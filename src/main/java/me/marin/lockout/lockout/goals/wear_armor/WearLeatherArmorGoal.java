package me.marin.lockout.lockout.goals.wear_armor;

import me.marin.lockout.lockout.interfaces.WearArmorGoal;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.List;

public class WearLeatherArmorGoal extends WearArmorGoal {

    private static final List<Item> ITEMS = List.of(Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS);

    public WearLeatherArmorGoal(String id, String data) {
        super(id, data);
    }

    @Override
    public String getGoalName() {
        return "Wear Full Leather Armor";
    }

    @Override
    public List<Item> getItems() {
        return ITEMS;
    }

}
