package com.crazyores.init.registration;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;

public class BlockRegistryObject<BLOCK extends Block, ITEM extends Item> extends DoubleRegistryObject<BLOCK, ITEM> {

    public BlockRegistryObject(RegistryObject<BLOCK> blockRegistryObject, RegistryObject<ITEM> itemRegistryObject) {
        super(blockRegistryObject, itemRegistryObject);
    }

    @Nonnull
    public BLOCK getBlock() {
        return getFirst();
    }

    @Nonnull
    public ITEM getItem() {
        return getSecond();
    }
}
