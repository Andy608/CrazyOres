package com.crazyores.event;

import com.crazyores.CrazyOres;
import com.crazyores.init.CoreItems;
import com.crazyores.item.CoreArmor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrazyOres.MODID)
public class InvisiumAntiTargetEvent {
    @SubscribeEvent
    public static void invisiumCancelAttack(LivingSetAttackTargetEvent event) {
        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof MobEntity
                && event.getTarget() != null && event.getTarget() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getTarget();
            if (CoreArmor.isWearingHelmet(player, CoreItems.INVISIUM_HELMET.get())
                    && CoreArmor.isWearingChestplate(player, CoreItems.INVISIUM_CHESTPLATE.get())
                    && CoreArmor.isWearingLeggings(player, CoreItems.INVISIUM_LEGGINGS.get())
                    && CoreArmor.isWearingBoots(player, CoreItems.INVISIUM_BOOTS.get())
                    && player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) {
                MobEntity mob = (MobEntity) event.getEntityLiving();
                mob.setAttackTarget(null);
            }
        }
    }
}
