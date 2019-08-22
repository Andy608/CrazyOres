package com.crazyores.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class CrazyOresConfig
{
	public static class Common
	{
		public final BooleanValue zectiumCoreExplodes;
		public final BooleanValue explosiveArrowExplodes;
		public final BooleanValue fireSpreadsArrow;
		
		public final BooleanValue spreadTapazite;
		
		public final IntValue foolsRubyGolemMaxHeight;

		Common(final ForgeConfigSpec.Builder builder)
		{
			builder.comment("Common config settings").push("common");

			zectiumCoreExplodes = builder.translation("config.node.zectiumCoreExplodes").define("zectiumCoreExplodes", true);
			explosiveArrowExplodes = builder.translation("config.node.explosiveArrowExplodes").define("explosiveArrowExplodes", true);
			fireSpreadsArrow = builder.translation("config.node.fireSpreadsArrow").define("fireSpreadsArrow", true);
			
			spreadTapazite = builder.translation("config.node.spreadTapazite").define("spreadTapazite", false);
			
			foolsRubyGolemMaxHeight = builder.translation("config.node.foolsRubyGolemMaxHeight").defineInRange("foolsRubyGolemMaxHeight", 50, 1, 50);
			
			builder.pop();
		}
	}

	public static class Client
	{
		Client(final ForgeConfigSpec.Builder builder)
		{
			//TODO: add client-side config nodes OR remove this altogether.
		}
	}

	private static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static
	{
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	private static final ForgeConfigSpec clientSpec;
	public static final Client CLIENT;

	static
	{
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}

	public static void register(final ModLoadingContext context)
	{
		context.registerConfig(ModConfig.Type.COMMON, commonSpec);
		context.registerConfig(ModConfig.Type.CLIENT, clientSpec);
	}
}
