package com.crazyores.event;

import com.crazyores.CrazyOres;
import com.crazyores.item.CoreArmor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = CrazyOres.MODID)
public class LivingEventHandler {
    public static final AttributeModifier slowness = (new AttributeModifier(
            UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160892"), "potion.moveArmorSlowdown",
            -0.1D, AttributeModifier.Operation.ADDITION));
    public static final AttributeModifier speed = (new AttributeModifier(
            UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160893"), "potion.moveArmorSpeed",
            0.2D, AttributeModifier.Operation.ADDITION));

    @SubscribeEvent
    public static void equipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity != null && !(entity instanceof PlayerEntity)) {
            if (CoreArmor.isWearingFullInvisiumSuit(entity)) {
                entity.setInvisible(true);
            }
            else if (entity.isInvisible() && !entity.isPotionActive(Effects.INVISIBILITY)) {
                entity.setInvisible(false);
            }

            IAttributeInstance attr = entity.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
            if (CoreArmor.isWearingFullOsmoniumSuit(entity)) {
                if (attr.getModifier(speed.getID()) == null) {
                    attr.applyModifier(speed);
                }
            }
            else if (attr.getModifier(speed.getID()) != null) {
                attr.removeModifier(speed);
            }

            if (CoreArmor.isWearingFullZectiumSuit(entity)) {
                if (attr.getModifier(slowness.getID()) == null) {
                    attr.applyModifier(slowness);
                }
            }
            else if (attr.getModifier(slowness.getID()) != null) {
                attr.removeModifier(slowness);
            }
        }
    }

    @SubscribeEvent
    public static void living(LivingEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity != null && !entity.getEntityWorld().isRemote && !(entity instanceof PlayerEntity)
                && CoreArmor.isWearingFullInvisiumSuit(entity)) {
            Random random = new Random();
            if (random.nextInt(100) == 0) {
                Iterator<ItemStack> iter = entity.getArmorInventoryList().iterator();
                if (iter.hasNext()) {
                    ItemStack item = iter.next();
                    item.damageItem(1, entity, (e) -> {
                        e.sendBreakAnimation(((ArmorItem)item.getItem()).getEquipmentSlot());
                    });
                }
            }
        }
    }
}
