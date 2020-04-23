package com.crazyores;

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
		
		CoreItems.ITEMS.register(modEventBus);
		CoreEntityTypes.ENTITY_TYPES.register(modEventBus);
	}
}
