package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class CoreHoe extends HoeItem {
	
	private IItemTier tier;
	
	public CoreHoe(IItemTier tier) {
		this(tier, 0.0F);
	}

	public CoreHoe(IItemTier tier, float attackSpeed) {
		super(tier, attackSpeed, ItemDeferredRegister.getBaseProps());
		this.tier = tier;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (tier.equals(CrazyTiers.METEORITE)) {
			target.setFire(8);
		}

		return super.hitEntity(stack, target, attacker);
	}

}
