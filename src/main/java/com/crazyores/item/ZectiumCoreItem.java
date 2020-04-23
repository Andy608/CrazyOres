package com.crazyores.item;

import com.crazyores.entity.projectile.ZectiumCoreEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ZectiumCoreItem extends Item {
	
	public ZectiumCoreItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);
		world.playSound((PlayerEntity)null, player.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		
		if (!world.isRemote) {
			ZectiumCoreEntity e = new ZectiumCoreEntity(world, player);
			e.func_213884_b(stack);
			e.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.addEntity(e);
		}
		
		player.addStat(Stats.ITEM_USED.get(this));
		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}
		
		return ActionResult.func_226248_a_(stack);
	}
}
