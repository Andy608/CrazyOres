package com.crazyores.client.event;

import com.crazyores.CrazyOres;
import com.crazyores.item.SwiftBow;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrazyOres.MODID, value = Dist.CLIENT)
public class FOVUpdateEventHandler {

    @SubscribeEvent
    public static void updateSwiftBowFOV(FOVUpdateEvent event) {
        PlayerEntity player = event.getEntity();
        if (player.isHandActive() && player.getActiveItemStack().getItem() instanceof SwiftBow) {
            float f = event.getFov();
            int i = player.getItemInUseMaxCount();
            float f1 = (float)i / 10.0F;
            if (f1 > 1.0F) {
                f1 = 1.0F;
            } else {
                f1 = f1 * f1;
            }

            f *= 1.0F - f1 * 0.15F;

            event.setNewfov(f);
        }
    }
}
