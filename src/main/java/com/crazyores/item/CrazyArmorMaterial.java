package com.crazyores.item;

import com.crazyores.CrazyOres;
import com.crazyores.init.CoreItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum CrazyArmorMaterial implements IArmorMaterial {

    COPPER("copper", 14, new int[]{1, 5, 3, 1}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, CoreItems.COPPER_INGOT.get()),
    METEORITE("meteorite", 5, new int[]{1, 3, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, CoreItems.METEORITE_GEM.get()),
    SAPPHIRE("sapphire", 21, new int[]{2, 6, 4, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, CoreItems.SAPPHIRE_GEM.get()),
    INVISIUM("invisium", 10, new int[]{1, 4, 3, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, CoreItems.INVISIUM_INGOT.get()),
    ADAMITE("adamite", 17, new int[]{2, 5, 4, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0F, CoreItems.ADAMITE_SHARD.get()),
    RUBY("ruby", 25, new int[]{3, 7, 5, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, CoreItems.RUBY_GEM.get()),
    ZECTIUM("zectium", 38, new int[]{4, 9, 7, 4}, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2.0F, CoreItems.ZECTIUM_INGOT.get()),
    TAPAZITE("tapazite", 42, new int[]{5, 10, 8, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F, CoreItems.TAPAZITE_OBELISK.get()),
    OSMONIUM("osmonium", 48, new int[]{3, 6, 5, 3}, 7, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, CoreItems.OSMONIUM_INGOT.get()),
    ENDER("ender", 43, new int[]{8, 9, 6, 5}, 6, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 3.0F, CoreItems.ENDER_GEM.get()),
    STARCONIUM("starconium", 53, new int[]{12, 13, 11, 8}, 6, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, CoreItems.STARCONIUM_GEM.get());

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private CrazyArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughness, Item repairMaterial) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughness;
        this.repairMaterial = new LazyValue<Ingredient>(() -> {
            return Ingredient.fromItems(repairMaterial);
        });
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return CrazyOres.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
}
