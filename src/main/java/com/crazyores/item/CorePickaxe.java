package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class CorePickaxe extends PickaxeItem {

	private IItemTier tier;

	public CorePickaxe(IItemTier tier) {
		super(tier, 1, -2.8F, ItemDeferredRegister.getBaseProps());
		this.tier = tier;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (tier.equals(CrazyTiers.METEORITE)) {
			target.setFire(8);
			stack.damageItem(2, attacker, (e) -> {
				e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});

			return true;
		}

		return super.hitEntity(stack, target, attacker);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		if (tier.equals(CrazyTiers.METEORITE)) {
			PlayerEntity playerentity = context.getPlayer();
			IWorld iworld = context.getWorld();
			BlockPos blockpos = context.getPos();
			BlockState blockstate = iworld.getBlockState(blockpos);
			if (isUnlitCampfire(blockstate)) {
				iworld.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						random.nextFloat() * 0.4F + 0.8F);
				iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
				if (playerentity != null) {
					context.getItem().damageItem(1, playerentity, (e) -> {
						e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
					});
				}

				return ActionResultType.SUCCESS;
			} else {
				BlockPos blockpos1 = blockpos.offset(context.getFace());
				if (isEligibleForFire(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
					iworld.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS,
							1.0F, random.nextFloat() * 0.4F + 0.8F);
					BlockState blockstate1 = ((FireBlock) Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
					iworld.setBlockState(blockpos1, blockstate1, 11);
					ItemStack itemstack = context.getItem();
					if (playerentity instanceof ServerPlayerEntity) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerentity, blockpos1, itemstack);
						itemstack.damageItem(1, playerentity, (e) -> {
							e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
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

	private static boolean isUnlitCampfire(BlockState state) {
		return state.getBlock() == Blocks.CAMPFIRE && !state.get(BlockStateProperties.WATERLOGGED)
				&& !state.get(BlockStateProperties.LIT);
	}

	@SuppressWarnings("deprecation")
	private static boolean isEligibleForFire(BlockState blockState, IWorld world, BlockPos blockPos) {
		BlockState fireBlockState = ((FireBlock) Blocks.FIRE).getStateForPlacement(world, blockPos);
		boolean flag = false;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos framePos = blockPos.offset(direction);
			if (world.getBlockState(framePos).isPortalFrame(world, framePos)
					&& ((NetherPortalBlock) Blocks.NETHER_PORTAL).isPortal(world, blockPos) != null) {
				flag = true;
			}
		}

		return blockState.isAir() && (fireBlockState.isValidPosition(world, blockPos) || flag);
	}

}
