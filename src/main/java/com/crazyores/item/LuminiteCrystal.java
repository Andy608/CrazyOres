package com.crazyores.item;

import com.crazyores.init.registration.ItemDeferredRegister;
import com.google.common.collect.Maps;
import net.minecraft.item.Item;

import java.util.Map;

public class LuminiteCrystal extends Item {
    private static final Map<LuminiteColor, LuminiteCrystal> COLOR_LUMINITE_CRYSTAL_MAP =
            Maps.newEnumMap(LuminiteColor.class);
    private final LuminiteColor luminiteColor;

    public LuminiteCrystal(LuminiteColor color) {
        super(ItemDeferredRegister.getBaseProps());
        this.luminiteColor = color;
        COLOR_LUMINITE_CRYSTAL_MAP.put(color, this);
    }

    public LuminiteColor getLuminiteColor() {
        return this.luminiteColor;
    }

    public static LuminiteCrystal getItem(LuminiteColor luminiteColor) {
        return COLOR_LUMINITE_CRYSTAL_MAP.get(luminiteColor);
    }
}
