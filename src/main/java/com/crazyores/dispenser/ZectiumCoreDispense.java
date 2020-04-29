package com.crazyores.dispenser;

import com.crazyores.entity.projectile.ZectiumCoreEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public class ZectiumCoreDispense extends ProjectileDispenseBehavior {

    @Override
    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected IProjectile getProjectileEntity(World world, IPosition position, ItemStack stackIn) {
        ZectiumCoreEntity core = Util.make(new ZectiumCoreEntity(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
            entity.func_213884_b(stackIn);
        });

        return core;
    }

    @Override
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        IPosition iposition = DispenserBlock.getDispensePosition(source);
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        IProjectile iprojectile = this.getProjectileEntity(world, iposition, stack);

        //PLEASE be careful with this line below. Velocity is *intentionally* set at -1F and inaccuracy at 0F
        // so that the Core is shot and rebounds into dispenser. This is only way for us to blow up the
        // dispenser, believe me, I've tried everything else...
        iprojectile.shoot((double)direction.getXOffset(), (double)((float)direction.getYOffset() + 0.1F), (double)direction.getZOffset(), -1F, 0.0F);

        world.addEntity((Entity)iprojectile);
        stack.shrink(1);
        return stack;
    }
}
