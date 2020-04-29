package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class CoreAxe extends AxeItem {

	private IItemTier tier;
	
	public CoreAxe(IItemTier tier) {
		super(tier, 6F, -3.2F, ItemDeferredRegister.getBaseProps());
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

	public ActionResultType onItemUse(ItemUseContext context) {
		if (tier.equals(CrazyTiers.METEORITE)) {
			PlayerEntity playerentity = context.getPlayer();
			IWorld iworld = context.getWorld();
			BlockPos blockpos = context.getPos();
			BlockState blockstate = iworld.getBlockState(blockpos);
			if (CorePickaxe.isUnlitCampfire(blockstate)) {
				iworld.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						random.nextFloat() * 0.4F + 0.8F);
				iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
				if (playerentity != null) {
					context.getItem().damageItem(1, playerentity, (e) -> {
						e.sendBreakAnimation(context.getHand());
					});
				}

				return ActionResultType.SUCCESS;
			} else {
				BlockPos blockpos1 = blockpos.offset(context.getFace());
				if (CorePickaxe.isEligibleForFire(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
					iworld.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS,
							1.0F, random.nextFloat() * 0.4F + 0.8F);
					BlockState blockstate1 = ((FireBlock) Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
					iworld.setBlockState(blockpos1, blockstate1, 11);
					ItemStack itemstack = context.getItem();
					if (playerentity instanceof ServerPlayerEntity) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerentity, blockpos1, itemstack);
						itemstack.damageItem(1, playerentity, (e) -> {
							e.sendBreakAnimation(context.getHand());
						});
					}

					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			}
		}

		return super.onItemUse(context);
	}
}
