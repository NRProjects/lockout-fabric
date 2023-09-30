package me.marin.lockout.lockout.goals.kill;

import me.marin.lockout.Constants;
import me.marin.lockout.lockout.interfaces.KillMobGoal;
import me.marin.lockout.lockout.texture.TextureProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class KillZombieVillagerGoal extends KillMobGoal implements TextureProvider {

    private static final Identifier TEXTURE = new Identifier(Constants.NAMESPACE, "textures/custom/undead/kill_zombie_villager.png");
    private static final Item ITEM = Items.ZOMBIE_VILLAGER_SPAWN_EGG;

    public KillZombieVillagerGoal(String id, String data) {
        super(id, data);
    }

    @Override
    public String getGoalName() {
        return "Kill a Zombie Villager";
    }

    @Override
    public ItemStack getTextureItemStack() {
        return ITEM.getDefaultStack();
    }

    @Override
    public EntityType<?> getEntity() {
        return EntityType.ZOMBIE_VILLAGER;
    }

    @Override
    public Identifier getTextureIdentifier() {
        return TEXTURE;
    }
}
