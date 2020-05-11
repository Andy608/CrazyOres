package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.init.registration.BlockDeferredRegister;
import com.crazyores.init.registration.BlockRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;

public class CoreBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(CrazyOres.MODID);

    public static final BlockRegistryObject<Block, BlockItem> DIAGONAL_BRICK = BLOCKS.register("diagonal_brick",
            Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0f, 10.0f));
}
