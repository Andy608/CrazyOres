package com.crazyores.item;

import java.util.function.Supplier;

import com.crazyores.init.CoreItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CrazyTiers implements IItemTier {
//	WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
//		return Ingredient.fromTag(ItemTags.PLANKS);
//	}),
//	GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//		return Ingredient.fromItems(Items.GOLD_INGOT);
//	}),
//	STONE(1, 131, 4.0F, 1.0F, 5, () -> {
//		return Ingredient.fromItems(Blocks.COBBLESTONE);
//	}),
	
	COPPER(2, 446, 5F, 1F, 14, () -> {
		return Ingredient.fromItems(CoreItems.COPPER_INGOT.get());
	}),
	METEORITE(2, 331, 4F, 1F, 20, () -> {
		return Ingredient.fromItems(CoreItems.METEORITE_GEM.get());
	}),
	
//	IRON(2, 250, 6.0F, 2.0F, 14, () -> {
//		return Ingredient.fromItems(Items.IRON_INGOT);
//	}),
	
	ADAMITE(4, 601, 7F, 2F, 13, () -> {
		return Ingredient.fromItems(CoreItems.ADAMITE_SHARD.get());
	}),
	SAPPHIRE(5, 861, 8F, 2F, 12, () -> {
		return Ingredient.fromItems(CoreItems.SAPPHIRE_GEM.get());
	}),
	RUBY(6, 1011, 8.5F, 3F, 12, () -> {
		return Ingredient.fromItems(CoreItems.RUBY_GEM.get());
	}),
	
//	DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
//		return Ingredient.fromItems(Items.DIAMOND);
//	}),
	
	INVISIUM(8, 538, 6F, 0F, 12, () -> {
		return Ingredient.fromItems(CoreItems.INVISIUM_INGOT.get());
	}),
	ZECTIUM(8, 1701, 10F, 4F, 9, () -> {
		return Ingredient.fromItems(CoreItems.ZECTIUM_INGOT.get());
	}),
	TAPAZITE(9, 612, 12F, 3F, 10, () -> {
		return Ingredient.fromItems(CoreItems.TAPAZITE_OBELISK.get());
	}),
	OSMONIUM(10, 2381, 20F, 4F, 7, () -> {
		return Ingredient.fromItems(CoreItems.OSMONIUM_INGOT.get());
	}),
	
	STARCONIUM(11, 3001, 16F, 8F, 6, () -> {
		return Ingredient.fromItems(CoreItems.STARCONIUM_GEM.get());
	}),
	STARCONIUM_HAMMER(11, 1066, 65F, 8F, 6, () -> {
		return Ingredient.fromItems(CoreItems.STARCONIUM_SHARD.get());
	}),
	
	ENDER(12, 2239, 15F, 7F, 6, () -> {
		return Ingredient.fromItems(CoreItems.ENDER_GEM.get());
	});
	
	// TODO: Reset Vanilla harvest levels
	// TODO: Set block harvest levels

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private CrazyTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
			int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}
}
