package com.crazyores;

import com.crazyores.item.CopperBucket;
import com.crazyores.util.EmptyBucketDispenseBehavior;
import com.crazyores.util.FullBucketDispenseBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crazyores.init.CoreEntityTypes;
import com.crazyores.init.CoreItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrazyOres.MODID)
public class CrazyOres {

	public static final String MODID = "crazyores";
	public static final String MOD_NAME = "CrazyOres";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public CrazyOres() {
//		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);

		CoreItems.ITEMS.register(modEventBus);
		CoreEntityTypes.ENTITY_TYPES.register(modEventBus);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		IDispenseItemBehavior idispenseitembehavior = new FullBucketDispenseBehavior();
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_LAVA.get(), idispenseitembehavior);
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_WATER.get(), idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.SALMON_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.COD_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.PUFFERFISH_BUCKET, idispenseitembehavior);
//		DispenserBlock.registerDispenseBehavior(Items.TROPICAL_FISH_BUCKET, idispenseitembehavior);
		DispenserBlock.registerDispenseBehavior(CoreItems.COPPER_BUCKET_EMPTY.get(), new EmptyBucketDispenseBehavior());
	}
}
