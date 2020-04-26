package com.crazyores.init;

import java.util.function.Supplier;

import com.crazyores.CrazyOres;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CrazyItemGroups {
	
	public static final ItemGroup CO_ITEMS_ITEM_GROUP = new ModItemGroup(CrazyOres.MODID, () -> new ItemStack(CoreItems.ZECTIUM_CORE.get()));
	
	public static class ModItemGroup extends ItemGroup {
		
		private final Supplier<ItemStack> iconSupplier;
		
		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}
