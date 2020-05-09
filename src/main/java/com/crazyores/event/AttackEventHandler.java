package com.crazyores.event;

import com.crazyores.CrazyOres;
import com.crazyores.item.CoreArmor;
import com.crazyores.item.CrazyTiers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrazyOres.MODID)
public class AttackEventHandler {
    @SubscribeEvent
    public static void invisiumArmorCancelsMobAttacks(LivingSetAttackTargetEvent event) {
        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof MobEntity
                && event.getTarget() != null && event.getTarget() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getTarget();
            if (CoreArmor.isWearingFullInvisiumSuit(player) && player.getHeldItemMainhand().isEmpty()
                    && player.getHeldItemOffhand().isEmpty()) {
                MobEntity mob = (MobEntity) event.getEntityLiving();
                mob.setAttackTarget(null);
            }
        }
    }

    @SubscribeEvent
    public static void modifyLivingAttack(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        LivingEntity target = event.getEntityLiving();

//        if (!target.world.isRemote) {
//            return;
//        }

        Entity trueSource = source.getTrueSource();

        if (trueSource != null /*&& !trueSource.world.isRemote*/ && trueSource instanceof MobEntity) {
            MobEntity attacker = (MobEntity) trueSource;
            Item heldItem = attacker.getHeldItemMainhand().getItem();
            if (heldItem instanceof TieredItem) {
                TieredItem weapon = (TieredItem) heldItem;
                IItemTier tier = weapon.getTier();
                if (tier == CrazyTiers.METEORITE) {
                    target.setFire(8);
                }
                else if (tier == CrazyTiers.INVISIUM) {
                    target.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 100, 0,
                            false, false));
                }
            }
        }

        if (CoreArmor.isWearingFullZectiumSuit(target) && source.isExplosion()) {
            float damageAmt = event.getAmount();
            int armorDamage = MathHelper.floor(damageAmt * 0.125F);
            Iterable<ItemStack> armorIter = target.getArmorInventoryList();
            armorIter.forEach(a -> a.damageItem(armorDamage, target, (e) -> {
                e.sendBreakAnimation(((ArmorItem)a.getItem()).getEquipmentSlot());
            }));
            event.setCanceled(true);
        }
        else if (!(target instanceof PlayerEntity) && CoreArmor.isWearingFullAdamiteSuit(target)
                && source == DamageSource.DROWN) {
            event.setCanceled(true);
        }
        else if (!(target instanceof PlayerEntity) && CoreArmor.isWearingFullMeteoriteSuit(target)
                && source.isFireDamage()) {
            event.setCanceled(true);
        }
        else if (CoreArmor.isWearingFullEnderSuit(target) && source == DamageSource.FALL) {
            float damageAmt = event.getAmount();
            int armorDamage = MathHelper.floor(damageAmt);
            Iterable<ItemStack> armorIter = target.getArmorInventoryList();
            armorIter.forEach(a -> a.damageItem(armorDamage, target, (e) -> {
                e.sendBreakAnimation(((ArmorItem)a.getItem()).getEquipmentSlot());
            }));
            event.setCanceled(true);
        }
    }
}
