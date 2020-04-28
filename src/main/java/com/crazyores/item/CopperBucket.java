package com.crazyores.item;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.crazyores.init.CoreItems;
import com.crazyores.util.CopperBucketWrapper;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class CopperBucket extends BucketItem {
	private final Fluid containedBlock;
	private final java.util.function.Supplier<? extends Fluid> fluidSupplier;

	public CopperBucket(Supplier<? extends Fluid> supplier, Properties builder) {
		super(supplier, builder);
		this.containedBlock = supplier.get();
		this.fluidSupplier = supplier;
	}

	@Override

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUse}.
	 */
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		RayTraceResult raytraceresult = rayTrace(world, player,
				this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY
						: RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(player, world,
				itemstack, raytraceresult);
		if (ret != null)
			return ret;
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.func_226250_c_(itemstack);
		} else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.func_226250_c_(itemstack);
		} else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
			BlockPos blockpos = blockraytraceresult.getPos();
			Direction direction = blockraytraceresult.getFace();
			BlockPos blockpos1 = blockpos.offset(direction);
			if (world.isBlockModifiable(player, blockpos)
					&& player.canPlayerEdit(blockpos1, direction, itemstack)) {
				if (this.containedBlock == Fluids.EMPTY) {
					BlockState blockstate1 = world.getBlockState(blockpos);
					if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
						Fluid fluid = ((IBucketPickupHandler) blockstate1.getBlock()).pickupFluid(world, blockpos,
								blockstate1);
						if (fluid != Fluids.EMPTY) {
							player.addStat(Stats.ITEM_USED.get(this));

							SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
							if (soundevent == null)
								soundevent = fluid.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_FILL_LAVA
										: SoundEvents.ITEM_BUCKET_FILL;
							player.playSound(soundevent, 1.0F, 1.0F);
							ItemStack itemstack1 = this.fillBucket(itemstack, player,
									getCopperVersionOfBucket(fluid.getFilledBucket()));
							if (!world.isRemote) {
								CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player,
										new ItemStack(getCopperVersionOfBucket(fluid.getFilledBucket())));
							}

							return ActionResult.func_226248_a_(itemstack1);
						}
					}
					else if (blockstate1.getBlock() instanceof CauldronBlock && !player.isCrouching()) {
						//_a SUCCESS, _b CONSUME, _c PASS, _d FAIL
						ActionResult<ItemStack> result = ActionResult.func_226248_a_(itemstack);
						CauldronBlock cauldron = (CauldronBlock)blockstate1.getBlock();
						
						int i = blockstate1.get(BlockStateProperties.LEVEL_0_3);
						if (i == 3 && !world.isRemote) {
							if (!player.abilities.isCreativeMode) {
								ItemStack water = new ItemStack(CoreItems.COPPER_BUCKET_WATER.get());
								
								itemstack.shrink(1);
								if (itemstack.isEmpty()) {
									result = ActionResult.func_226248_a_(water);
								}
								else if (!player.inventory.addItemStackToInventory(water)) {
									player.dropItem(water, false);
								}
							}
							
							player.addStat(Stats.USE_CAULDRON);
							cauldron.setWaterLevel(world, blockpos, blockstate1, 0);
							world.playSound((PlayerEntity)null, blockpos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						}
						
						return result;
					}

					return ActionResult.func_226251_d_(itemstack);
				} else {
					BlockState blockstate = world.getBlockState(blockpos);
					BlockPos blockpos2 = blockstate.getBlock() instanceof ILiquidContainer
							&& this.containedBlock == Fluids.WATER ? blockpos : blockpos1;
					
					if (this.containedBlock == Fluids.WATER && blockstate.getBlock() instanceof CauldronBlock && !player.isCrouching()) {
						//_a SUCCESS, _b CONSUME, _c PASS, _d FAIL
						ActionResult<ItemStack> result = ActionResult.func_226248_a_(itemstack);
						CauldronBlock cauldron = (CauldronBlock) blockstate.getBlock();
						
						int i = blockstate.get(BlockStateProperties.LEVEL_0_3);
						if (i < 3 && !world.isRemote) {
							if (!player.abilities.isCreativeMode) {
								result = ActionResult.func_226248_a_(new ItemStack(CoreItems.COPPER_BUCKET_EMPTY.get()));
							}
							
							player.addStat(Stats.FILL_CAULDRON);
							cauldron.setWaterLevel(world, blockpos, blockstate, 3);
							world.playSound((PlayerEntity)null, blockpos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
						}
						
						return result;
					}
					
					if (this.tryPlaceContainedLiquid(player, world, blockpos2, blockraytraceresult)) {
						this.onLiquidPlaced(world, itemstack, blockpos2);
						if (player instanceof ServerPlayerEntity) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockpos2, itemstack);
						}

						player.addStat(Stats.ITEM_USED.get(this));
						return ActionResult.func_226248_a_(this.emptyBucket(itemstack, player));
					} else {
						return ActionResult.func_226251_d_(itemstack);
					}
				}
			} else {
				return ActionResult.func_226251_d_(itemstack);
			}
		}
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
		if (this.containedBlock == Fluids.EMPTY && target instanceof CowEntity) {
			CowEntity cow = (CowEntity) target;
			if (!player.abilities.isCreativeMode && !cow.isChild()) {
				player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
				stack.shrink(1);
				if (stack.isEmpty()) {
					player.setHeldItem(hand, new ItemStack(CoreItems.COPPER_BUCKET_MILK.get()));
				}
				else if (!player.inventory.addItemStackToInventory(new ItemStack(CoreItems.COPPER_BUCKET_MILK.get()))) {
					player.dropItem(new ItemStack(CoreItems.COPPER_BUCKET_MILK.get()), false);
				}
			}
		}
		return super.itemInteractionForEntity(stack, player, target, hand);
	}

	private ItemStack fillBucket(ItemStack emptyBuckets, PlayerEntity player, Item fullBucket) {
		if (player.abilities.isCreativeMode) {
			return emptyBuckets;
		} else {
			emptyBuckets.shrink(1);
			if (emptyBuckets.isEmpty()) {
				return new ItemStack(fullBucket);
			} else {
				if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket))) {
					player.dropItem(new ItemStack(fullBucket), false);
				}

				return emptyBuckets;
			}
		}
	}

	@Override
	protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
		return !player.abilities.isCreativeMode ? new ItemStack(CoreItems.COPPER_BUCKET_EMPTY.get()) : stack;
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack,
			@Nullable net.minecraft.nbt.CompoundNBT nbt) {
		return new CopperBucketWrapper(stack);
	}

	@Override
	public Fluid getFluid() {
		return fluidSupplier.get();
	}

	/**
	 * @author ISQ
	 * @implNote Gotta be ItemStack-sensitive these days... this function converts a
	 *           standard MC iron bucket to Copper version.
	 **/
	public static Item getCopperVersionOfBucket(ItemStack bucket) {
		return getCopperVersionOfBucket(bucket.getItem());
	}

	/**
	 * @author ISQ
	 * @implNote This function converts a standard MC iron bucket to Copper version.
	 **/
	public static Item getCopperVersionOfBucket(Item bucket) {
		/*
		 * TODO: So uhhh... apparently somewhere in between 1.7.10 and 1.15 they decided
		 * to add fish entities in the water, which is dope. But also you can catch fish
		 * with a bucket now?
		 * 
		 * So... should we be considering this?
		 */

		if (bucket == Items.BUCKET) {
			return CoreItems.COPPER_BUCKET_EMPTY.get();
		} else if (bucket == Items.LAVA_BUCKET) {
			return CoreItems.COPPER_BUCKET_LAVA.get();
		} else if (bucket == Items.WATER_BUCKET) {
			return CoreItems.COPPER_BUCKET_WATER.get();
		} else if (bucket == Items.MILK_BUCKET) {
			return CoreItems.COPPER_BUCKET_MILK.get();
		}
		return CoreItems.COPPER_BUCKET_EMPTY.get();
	}
}
