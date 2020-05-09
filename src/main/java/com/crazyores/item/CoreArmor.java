package com.crazyores.item;

import com.crazyores.init.CoreItems;
import com.crazyores.init.registration.ItemDeferredRegister;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class CoreArmor extends ArmorItem {
    public CoreArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, ItemDeferredRegister.getBaseProps());
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        final int REAPPLY_DURATION = 2;

        if (!world.isRemote || player == null || stack == null || stack.isEmpty()) {
            return;
        }

        if (isWearingFullInvisiumSuit(player)) {
            if (player.getActivePotionEffect(Effects.INVISIBILITY) == null
                    || player.getActivePotionEffect(Effects.INVISIBILITY).getDuration() < REAPPLY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, REAPPLY_DURATION, 0,
                        false, false));
            }

            if (world.getRandom().nextInt(100) == 0) {
                stack.damageItem(1, player, (e) -> {
                    e.sendBreakAnimation(((ArmorItem)stack.getItem()).getEquipmentSlot());
                });
            }
        }
        else if (isWearingFullAdamiteSuit(player) && !player.abilities.isCreativeMode) {
            if (player.getActivePotionEffect(Effects.WATER_BREATHING) == null
                    || player.getActivePotionEffect(Effects.WATER_BREATHING).getDuration() < REAPPLY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, REAPPLY_DURATION, 0,
                        false, false));
            }

            if (player.canSwim() && world.getRandom().nextInt(50) == 0) {
                stack.damageItem(1, player, (e) -> {
                    e.sendBreakAnimation(((ArmorItem)stack.getItem()).getEquipmentSlot());
                });
            }
        }
        else if (isWearingFullZectiumSuit(player) && !player.abilities.isCreativeMode) {
            if (player.getActivePotionEffect(Effects.SLOWNESS) == null
                    || player.getActivePotionEffect(Effects.SLOWNESS).getDuration() < REAPPLY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, REAPPLY_DURATION, 0,
                        false, false));
            }
        }
        else if (isWearingFullMeteoriteSuit(player)) {
            if (player.getActivePotionEffect(Effects.FIRE_RESISTANCE) == null
                    || player.getActivePotionEffect(Effects.FIRE_RESISTANCE).getDuration() < REAPPLY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, REAPPLY_DURATION, 0,
                        false, false));
            }

            if ((player.isInLava() || player.isBurning()) && world.getRandom().nextInt(1000) == 0) {
                stack.damageItem(1, player, (e) -> {
                    e.sendBreakAnimation(((ArmorItem)stack.getItem()).getEquipmentSlot());
                });
            }
        }
        else if (isWearingFullOsmoniumSuit(player)) {
            if (player.getActivePotionEffect(Effects.SPEED) == null
                    || player.getActivePotionEffect(Effects.SPEED).getDuration() < REAPPLY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, REAPPLY_DURATION, 0,
                        false, false));
            }

            if (!player.isSwimming() && player.isSprinting() && world.getRandom().nextInt(100) == 0) {
                stack.damageItem(1, player, (e) -> {
                    e.sendBreakAnimation(((ArmorItem)stack.getItem()).getEquipmentSlot());
                });
            }
        }
    }

    public static boolean isWearingFullInvisiumSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.INVISIUM_HELMET.get())
                && isWearingChestplate(entity, CoreItems.INVISIUM_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.INVISIUM_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.INVISIUM_BOOTS.get());
    }

    public static boolean isWearingFullAdamiteSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.ADAMITE_HELMET.get())
                && isWearingChestplate(entity, CoreItems.ADAMITE_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.ADAMITE_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.ADAMITE_BOOTS.get());
    }

    public static boolean isWearingFullZectiumSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.ZECTIUM_HELMET.get())
                && isWearingChestplate(entity, CoreItems.ZECTIUM_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.ZECTIUM_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.ZECTIUM_BOOTS.get());
    }

    public static boolean isWearingFullMeteoriteSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.METEORITE_HELMET.get())
                && isWearingChestplate(entity, CoreItems.METEORITE_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.METEORITE_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.METEORITE_BOOTS.get());
    }

    public static boolean isWearingFullEnderSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.ENDER_HELMET.get())
                && isWearingChestplate(entity, CoreItems.ENDER_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.ENDER_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.ENDER_BOOTS.get());
    }

    public static boolean isWearingFullOsmoniumSuit(LivingEntity entity) {
        return isWearingHelmet(entity, CoreItems.OSMONIUM_HELMET.get())
                && isWearingChestplate(entity, CoreItems.OSMONIUM_CHESTPLATE.get())
                && isWearingLeggings(entity, CoreItems.OSMONIUM_LEGGINGS.get())
                && isWearingBoots(entity, CoreItems.OSMONIUM_BOOTS.get());
    }

    public static boolean isWearingHelmet(LivingEntity entity, Item helmet) {
        if (entity != null && helmet != null) {
            return entity.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(helmet);
        }
        return false;
    }

    public static boolean isWearingChestplate(LivingEntity entity, Item chestplate) {
        if (entity != null && chestplate != null) {
            return entity.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(chestplate);
        }
        return false;
    }

    public static boolean isWearingLeggings(LivingEntity entity, Item leggings) {
        if (entity != null && leggings != null) {
            return entity.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(leggings);
        }
        return false;
    }

    public static boolean isWearingBoots(LivingEntity entity, Item boots) {
        if (entity != null && boots != null) {
            return entity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(boots);
        }
        return false;
    }
}
