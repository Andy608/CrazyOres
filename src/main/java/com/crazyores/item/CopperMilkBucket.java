package com.crazyores.item;

import com.crazyores.init.CoreItems;
import com.crazyores.init.registration.ItemDeferredRegister;
import com.crazyores.util.CopperBucketWrapper;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class CopperMilkBucket extends MilkBucketItem {

	public CopperMilkBucket() {
		super(ItemDeferredRegister.getBaseProps().containerItem(CoreItems.COPPER_BUCKET_EMPTY.get()).maxStackSize(1));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if (!worldIn.isRemote)
			entityLiving.curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air

		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.addStat(Stats.ITEM_USED.get(this));
		}

		if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!worldIn.isRemote) {
			entityLiving.clearActivePotions();
		}

		return stack.isEmpty() ? new ItemStack(CoreItems.COPPER_BUCKET_EMPTY.get()) : stack;
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack,
			@javax.annotation.Nullable net.minecraft.nbt.CompoundNBT nbt) {
		return new CopperBucketWrapper(stack);
	}

}
