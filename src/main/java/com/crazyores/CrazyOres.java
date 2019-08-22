package com.crazyores;

import com.crazyores.util.LoggerUtil;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrazyOres.MOD_ID)
public class CrazyOres 
{	
	public static final String clientProxy = "crazyores.manager.proxy.ClientProxy";
	public static final String serverProxy = "crazyores.manager.proxy.ServerProxy";
	
	public static final String MOD_ID = "crazyores";
	public static final String MOD_NAME = "CrazyOres";
	public static final String CORE_VERSION = "3.0.0";

	public CrazyOres() 
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
    {
		LoggerUtil.info("HELLO FROM PREINIT");
    }
	
	private void clientSetup(final FMLClientSetupEvent event) 
	{
    }
}
