package com.crazyores.util;

import com.crazyores.item.CopperBucket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class EmptyBucketDispenseBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior field_229426_b_ = new DefaultDispenseItemBehavior();

    @Override
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        IWorld iworld = source.getWorld();
        BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState blockstate = iworld.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof IBucketPickupHandler) {
            Fluid fluid = ((IBucketPickupHandler)block).pickupFluid(iworld, blockpos, blockstate);
            if (!(fluid instanceof FlowingFluid)) {
                return super.dispenseStack(source, stack);
            } else {
                Item item = CopperBucket.getCopperVersionOfBucket(fluid.getFilledBucket());
                stack.shrink(1);
                if (stack.isEmpty()) {
                    return new ItemStack(item);
                } else {
                    if (source.<DispenserTileEntity>getBlockTileEntity().addItemStack(new ItemStack(item)) < 0) {
                        this.field_229426_b_.dispense(source, new ItemStack(item));
                    }

                    return stack;
                }
            }
        } else {
            return super.dispenseStack(source, stack);
        }
    }
}
