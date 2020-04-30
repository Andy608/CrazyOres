package com.crazyores.init.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.crazyores.init.CrazyItemGroups;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemDeferredRegister extends CoreDeferredRegister<Item> {

	private final List<CoreRegistryObject<? extends Item>> itemList = new ArrayList<>();
	
	public ItemDeferredRegister(String modid) {
		super(modid, ForgeRegistries.ITEMS);
	}
	
	public static Item.Properties getBaseProps() {
		return new Item.Properties().group(CrazyItemGroups.CRAZYORES_ITEM_GROUP);
	}
	
	public CoreRegistryObject<Item> register(String name) {
		return register(name, () -> new Item(getBaseProps()));
	}
	
	public <I extends Item> CoreRegistryObject<I> register(String name, Function<Item.Properties, I> func) {
		return register(name, () -> func.apply(getBaseProps()));
	}
	
	public <I extends Item> CoreRegistryObject<I> register(String name, Supplier<? extends I> supplier) {
		CoreRegistryObject<I> registeredItem = register(name, supplier, CoreRegistryObject::new);
		itemList.add(registeredItem);
		return registeredItem;
	}
	
	public List<CoreRegistryObject<? extends Item>> getItemList() {
		return itemList;
	}

}
