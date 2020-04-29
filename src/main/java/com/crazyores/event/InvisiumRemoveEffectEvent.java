package com.crazyores.event;

import com.crazyores.CrazyOres;
import com.crazyores.util.InvisiumEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = CrazyOres.MODID)
public class InvisiumRemoveEffectEvent {
    @SubscribeEvent
    public static void waningEffect(PotionEvent.PotionExpiryEvent event) {
        CrazyOres.LOGGER.log(Level.DEBUG, "oh hey there pal");
        if (event.getEntity() instanceof LivingEntity && event.getPotionEffect() instanceof InvisiumEffectInstance) {
            LivingEntity entity = (LivingEntity) event.getEntity();
            InvisiumEffectInstance oldEffect = (InvisiumEffectInstance) event.getPotionEffect();
            int waneCount = oldEffect.getWaneCount();

            if (waneCount > 0) {
                InvisiumEffectInstance effect = new InvisiumEffectInstance(20, waneCount - 1);
                CrazyOres.LOGGER.log(Level.DEBUG, "wane " + Integer.toString(waneCount));
                entity.addPotionEffect(effect);
            }
        }
    }

    @SubscribeEvent
    public static void added(PotionEvent.PotionAddedEvent event) {
        CrazyOres.LOGGER.log(Level.DEBUG, "i got added!" + event.getPotionEffect().toString());
    }
}
