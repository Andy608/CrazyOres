package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

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
		boolean success = true;

		if (tier.equals(CrazyTiers.METEORITE)) {
			target.setFire(8);
		}
		else if (tier.equals(CrazyTiers.INVISIUM)) {
			success = target.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 100, 0, false, false));
		}

		return success && super.hitEntity(stack, target, attacker);
	}

}
