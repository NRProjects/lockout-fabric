package me.marin.lockout.mixin.server;

import me.marin.lockout.Lockout;
import me.marin.lockout.lockout.Goal;
import me.marin.lockout.lockout.goals.status_effect.GetXStatusEffectsGoal;
import me.marin.lockout.lockout.interfaces.StatusEffectGoal;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {

    @Inject(method = "onApplied(Lnet/minecraft/entity/LivingEntity;I)V", at = @At("HEAD"))
    public void onApplied(LivingEntity entity, int amplifier, CallbackInfo ci) {
        if (FabricLoader.getInstance().getEnvironmentType() != EnvType.SERVER) return;
        if (!Lockout.isRunning()) return;
        if (!(entity instanceof PlayerEntity player)) return;

        Lockout lockout = Lockout.getInstance();

        for (Goal goal : lockout.getBoard().getGoals()) {
            if (goal == null) continue;
            if (goal.isCompleted()) continue;

            StatusEffect statusEffect = (StatusEffect) (Object) this;
            if (goal instanceof StatusEffectGoal statusEffectGoal) {
                if (statusEffectGoal.getStatusEffect().equals(statusEffect)) {
                    lockout.completeGoal(statusEffectGoal, player);
                }
            }
            if (goal instanceof GetXStatusEffectsGoal getXStatusEffectsGoal) {
                if (player.getStatusEffects().size() >= getXStatusEffectsGoal.getAmount()) {
                    lockout.completeGoal(goal, player);
                }
            }
        }
    }

}
