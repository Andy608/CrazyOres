package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//TODO: UNFINISHED
public class CoreSledgehammer extends TieredItem {
	private final IItemTier tier;
	private final float attackDamage;
	private final float attackSpeed;

	public CoreSledgehammer(int attackDamageIn, float attackSpeedIn, IItemTier tier) {
		super(tier, ItemDeferredRegister.getBaseProps());
		this.tier = tier;
		this.attackDamage = (float) attackDamageIn + tier.getAttackDamage();
		this.attackSpeed = attackSpeedIn;
	}

	@Override
	public boolean canHarvestBlock(BlockState blockIn) {
		Block block = blockIn.getBlock();
		int i = this.getTier().getHarvestLevel();
		if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE
				|| blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.SHOVEL
				|| blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.AXE) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL
				|| block == Blocks.SNOW || block == Blocks.SNOW_BLOCK || blockIn.getBlock() == Blocks.COBWEB;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return tier.getEfficiency();
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		if (!worldIn.isRemote && state.getBlockHardness(worldIn, pos) != 0.0F) {
			stack.damageItem(1, entityLiving, (p_220038_0_) -> {
				p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});
		}

		return true;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(1, attacker, (p_220045_0_) -> {
			p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stac) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
					"Weapon modifier", (double) this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER,
					"Weapon modifier", (double) this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}

		return multimap;
	}
}
