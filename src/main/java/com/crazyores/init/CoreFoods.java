package com.crazyores.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

public class CoreFoods {
    public static final Food CHOCOLATE_MILK = (new Food.Builder()).hunger(4).saturation(0.1F).setAlwaysEdible().build();
    public static final Food HOT_CHOCOLATE = (new Food.Builder()).hunger(6).saturation(0.2F).setAlwaysEdible().build();

    /**
     * Utility function for feeding player without shrinking stack or playing sound effect.
     */
    public static void eatFoodUtility(ItemStack stack, World world, LivingEntity entity) {
        Item item = stack.getItem();
        if (item.isFood()) {
            if (entity instanceof PlayerEntity) {
                ((PlayerEntity)entity).getFoodStats().consume(item, stack);
            }

            for(Pair<EffectInstance, Float> pair : item.getFood().getEffects()) {
                if (!world.isRemote && pair.getLeft() != null && world.rand.nextFloat() < pair.getRight()) {
                    entity.addPotionEffect(new EffectInstance(pair.getLeft()));
                }
            }
        }
    }
}
