package com.crazyores.entity.projectile;

import com.crazyores.init.CoreEntityTypes;
import com.crazyores.init.CoreItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ZectiumCoreEntity extends ProjectileItemEntity {

	public ZectiumCoreEntity(EntityType<? extends ZectiumCoreEntity> type, World world) {
		super(type, world);
	}
	
	public ZectiumCoreEntity(World world, LivingEntity thrower) {
		super(CoreEntityTypes.ZECTIUM_CORE.get(), thrower, world);
	}

	public ZectiumCoreEntity(World world, double x, double y, double z) {
	   super(CoreEntityTypes.ZECTIUM_CORE.get(), x, y, z, world);
	}

	@Override
	protected Item func_213885_i() {
		return CoreItems.ZECTIUM_CORE.get();
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			Vec3d pos = result.getHitVec();
			
			//if (COConfigSettings.zectiumCoreExplodes) {
			this.world.createExplosion(this, pos.x, pos.y, pos.z, 4f, Explosion.Mode.BREAK);
			//}
			
			this.world.setEntityState(this, (byte)3);
	        this.remove();
		}
	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
