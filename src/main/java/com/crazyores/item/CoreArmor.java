package com.crazyores.item;

import com.crazyores.CrazyOres;
import com.crazyores.init.CoreItems;
import com.crazyores.init.registration.ItemDeferredRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Core;

public class CoreArmor extends ArmorItem {
    public CoreArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, ItemDeferredRegister.getBaseProps());
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        final int INVISIBILITY_DURATION = 2;
        if (isWearingHelmet(player, CoreItems.INVISIUM_HELMET.get())
                && isWearingChestplate(player, CoreItems.INVISIUM_CHESTPLATE.get())
                && isWearingLeggings(player, CoreItems.INVISIUM_LEGGINGS.get())
                && isWearingBoots(player, CoreItems.INVISIUM_BOOTS.get())) {
            if (player.getActivePotionEffect(Effects.INVISIBILITY) == null
                    || player.getActivePotionEffect(Effects.INVISIBILITY).getDuration() < INVISIBILITY_DURATION) {
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, INVISIBILITY_DURATION, 0,
                        false, false));
                if (world.getDayTime() % 20 == 0) {
                    this.damageItem(stack, 1, player, (p_214023_1_) -> {
                        p_214023_1_.sendBreakAnimation(EquipmentSlotType.func_220318_a(EquipmentSlotType.Group.ARMOR,
                                this.getEquipmentSlot().getIndex()));
                    });
                }
            }
        }
    }

    public static boolean isWearingHelmet(PlayerEntity player, Item helmet) {
        return player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(helmet);
    }

    public static boolean isWearingChestplate(PlayerEntity player, Item chestplate) {
        return player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(chestplate);
    }

    public static boolean isWearingLeggings(PlayerEntity player, Item leggings) {
        return player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(leggings);
    }

    public static boolean isWearingBoots(PlayerEntity player, Item boots) {
        return player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(boots);
    }
}
