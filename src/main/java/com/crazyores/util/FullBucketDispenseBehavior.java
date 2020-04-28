package com.crazyores.util;

import com.crazyores.init.CoreItems;
import com.crazyores.item.CopperBucket;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class FullBucketDispenseBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior field_218406_b = new DefaultDispenseItemBehavior();

    @Override
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        CopperBucket bucketitem = (CopperBucket) stack.getItem();
        BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        World world = source.getWorld();
        if (bucketitem.tryPlaceContainedLiquid((PlayerEntity)null, world, blockpos, (BlockRayTraceResult)null)) {
            bucketitem.onLiquidPlaced(world, stack, blockpos);
            return new ItemStack(CoreItems.COPPER_BUCKET_EMPTY.get());
        } else {
            return this.field_218406_b.dispense(source, stack);
        }
    }
}
