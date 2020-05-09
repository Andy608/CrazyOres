package com.crazyores.client.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crazyores.CrazyOres;
import com.crazyores.entity.projectile.ZectiumCoreEntity;
import com.crazyores.init.CoreEntityTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = CrazyOres.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber {
	private static final Logger LOGGER = LogManager.getLogger(CrazyOres.MOD_NAME + " Client Mod Event Subscriber");
	
	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CoreEntityTypes.ZECTIUM_CORE.get(),
				renderManager -> new SpriteRenderer<ZectiumCoreEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		LOGGER.debug("Registered entity renderers!");
		
//				new IRenderFactory<Entity>() {
//
//			@Override
//			public EntityRenderer<? super Entity> createRenderFor(EntityRendererManager manager) {
//				return new SpriteRenderer<ZectiumCoreEntity>(manager, Minecraft.getInstance().getItemRenderer());
//			}
//			
//		});
	}
}
