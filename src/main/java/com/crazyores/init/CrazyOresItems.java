package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.item.ItemOre;
import com.crazyores.util.LoggerUtil;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static com.crazyores.util.InjectionUtil.Null;

import java.util.HashSet;
import java.util.Set;

@ObjectHolder(CrazyOres.MOD_ID)
public class CrazyOresItems
{
    public static final ItemOre COPPER_INGOT = Null();

    //public static class VariantGroups
    //{
    //    public static final ItemVariantGroup<VariantsItem.Type, VariantsItem> VARIANTS_ITEMS 
    //    = ItemVariantGroup.Builder.<VariantsItem.Type, VariantsItem>create()
	//			.groupName("variants_item")
	//			.suffix()
	//			.variants(VariantsItem.Type.values())
	//			.itemFactory(VariantsItem::new)
	//			.build();
    //}

    @Mod.EventBusSubscriber(modid = CrazyOres.MOD_ID, bus = Bus.MOD)
    public static class RegistrationHandler
    {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            //ModSoundEvents.RegistrationHandler.initialiseSoundEvents();

            final Item[] items = 
            {
                new ItemOre(defaultProperties()).setRegistryName("copper_ingot")
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final Item item : items)
            {
                registry.register(item);
                ITEMS.add(item);
                //LoggerUtil.info("Registering item: " + item.getName());
            }

            //registerItemVariantGroup(registry, VariantGroups.VARIANTS_ITEMS);
        }

        private static Item.Properties defaultProperties()
        {
            return new Item.Properties();//.group(CrazyOres.ITEM_GROUP);
        }

        //private static void registerItemVariantGroup(final IForgeRegistry<Item> registry, final IItemVariantGroup<?, ?> variantGroup)
        //{
        //    variantGroup.registerItems(registry);
		//	ITEMS.addAll(variantGroup.getItems());
        //}
    }
}