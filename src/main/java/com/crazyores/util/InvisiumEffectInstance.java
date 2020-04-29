package com.crazyores.util;

import com.crazyores.CrazyOres;
import com.google.common.collect.ComparisonChain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.apache.logging.log4j.Level;

public class InvisiumEffectInstance extends EffectInstance implements Comparable<EffectInstance>, net.minecraftforge.common.extensions.IForgeEffectInstance {

    private int duration;
    private int waneCount;

    /**
     * Applies invisibility effect with no amplifier, ambient off, and particles off for
     * the specified duration. If duration is eligible (see below), then two-fifths of the
     * way through the effect, entity will start blinking.
     *
     * DURATION MUST BE AT LEAST 50 FOR WANING EFFECT!
     */
    public InvisiumEffectInstance(int durationIn, int waneCount) {
        super(Effects.INVISIBILITY, durationIn, 0, false, false);
        this.duration = durationIn;
        this.waneCount = waneCount;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    public int getWaneCount() {
        return this.waneCount;
    }

    private int deincrementDuration() {
        return --this.duration;
    }

    @Override
    public void performEffect(LivingEntity entityIn) {
        if (this.duration > 0) {
            this.getPotion().performEffect(entityIn, 0);
        }

    }

    public boolean combine(EffectInstance other) {
        this.duration = other.getDuration();

        return true;
    }

    @Override
    public boolean tick(LivingEntity entityIn, Runnable p_76455_2_) {

        if (this.duration > 0) {
            if (this.getPotion().isReady(this.duration, 0)) {
                this.performEffect(entityIn);
            }

            this.deincrementDuration();
        }

        return this.duration > 0;
    }

    public String toString() {
        String s;
        s = this.getEffectName() + ", Duration: " + this.duration;
        s = s + ", Particles: false";

        return s;
    }

    @Override
    public boolean equals(Object p_equals_1_) {
        if (this == p_equals_1_) {
            return true;
        } else if (!(p_equals_1_ instanceof InvisiumEffectInstance)) {
            return false;
        } else {
            InvisiumEffectInstance effectinstance = (InvisiumEffectInstance)p_equals_1_;
            return this.duration == effectinstance.getDuration();
        }
    }

    @Override
    public int hashCode() {
        int i = this.getPotion().hashCode();
        i = 31 * i + this.duration;
        i = 31 * i;
        i = 31 * i;
        i = 31 * i;
        return i;
    }

    @Override
    /**
     * Write a custom potion effect to a potion item's NBT data.
     */
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putByte("Id", (byte)Effect.getId(this.getPotion()));
        this.writeData(nbt);
        return nbt;
    }

    private void writeData(CompoundNBT p_230119_1_) {
        p_230119_1_.putByte("Amplifier", (byte)this.getAmplifier());
        p_230119_1_.putInt("Duration", getDuration());
        p_230119_1_.putBoolean("Ambient", this.isAmbient());
        p_230119_1_.putBoolean("ShowParticles", this.doesShowParticles());
        p_230119_1_.putBoolean("ShowIcon", this.isShowIcon());
        writeCurativeItems(p_230119_1_);

    }

    @Override
    public int compareTo(EffectInstance p_compareTo_1_) {
        int i = 32147;
        return (this.getDuration() <= 32147 || p_compareTo_1_.getDuration() <= 32147) && (!this.isAmbient() || !p_compareTo_1_.isAmbient()) ? ComparisonChain.start().compare(this.isAmbient(), p_compareTo_1_.isAmbient()).compare(this.getDuration(), p_compareTo_1_.getDuration()).compare(this.getPotion().getGuiSortColor(this), p_compareTo_1_.getPotion().getGuiSortColor(this)).result() : ComparisonChain.start().compare(this.isAmbient(), p_compareTo_1_.isAmbient()).compare(this.getPotion().getGuiSortColor(this), p_compareTo_1_.getPotion().getGuiSortColor(this)).result();
    }
}
