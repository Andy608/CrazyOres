package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.entity.projectile.ZectiumCoreEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, CrazyOres.MODID);
	
	public static final String ZECTIUM_CORE_NAME = "zectium_core";
	public static final RegistryObject<EntityType<ZectiumCoreEntity>> ZECTIUM_CORE = ENTITY_TYPES.register(ZECTIUM_CORE_NAME, () ->
			EntityType.Builder.<ZectiumCoreEntity>create(ZectiumCoreEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).build(ZECTIUM_CORE_NAME));
}
