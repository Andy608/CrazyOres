package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoreArmor extends ArmorItem {
    public CoreArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, ItemDeferredRegister.getBaseProps());
    }

//    @Override
//    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
//    {
//        //for invisium etc.?
//    }
}
