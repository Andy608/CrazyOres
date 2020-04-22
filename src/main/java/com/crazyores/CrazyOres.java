package com.crazyores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(CrazyOres.MODID)
public class CrazyOres {

	public static final String MODID = "crazyores";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public CrazyOres() {
		LOGGER.debug("Hello from CrazyOres!");
	}
	
}
