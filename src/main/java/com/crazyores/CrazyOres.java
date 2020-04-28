package com.crazyores;

import com.crazyores.dispenser.EmptyBucketDispense;
import com.crazyores.dispenser.FullBucketDispense;
import com.crazyores.dispenser.ZectiumCoreDispense;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crazyores.init.CoreEntityTypes;
import com.crazyores.init.CoreItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrazyOres.MODID)
public class CrazyOres {

	public static final String MODID = "crazyores";
	public static final String MOD_NAME = "CrazyOres";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public CrazyOres() {
//		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);

		CoreItems.ITEMS.register(modEventBus);
		CoreEntityTypes.ENTITY_TYPES.register(modEventBus);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		IDispenseItemBehavior idispenseitembehavior = new FullBucketDispense();
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_LAVA.get(), idispenseitembehavior);
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_WATER.get(), idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.SALMON_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.COD_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.PUFFERFISH_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.TROPICAL_FISH_BUCKET, idispenseitembehavior);
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_EMPTY.get(), new EmptyBucketDispense());
		DispenserBlock.registerDispenseBehavior(CoreItems.ZECTIUM_CORE.get(), new ZectiumCoreDispense());
	}
}
