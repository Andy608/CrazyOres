package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.item.ZectiumCoreItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CrazyOres.MODID);
	
	public static final RegistryObject<Item> ZECTIUM_CORE = ITEMS.register("zectium_core", () -> new ZectiumCoreItem(new Item.Properties().maxStackSize(32).group(ModItemGroups.CO_ITEMS_ITEM_GROUP)));
}
