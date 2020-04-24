package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.init.registration.CoreRegistryObject;
import com.crazyores.init.registration.ItemDeferredRegister;
import com.crazyores.item.ZectiumCoreItem;

import net.minecraft.item.Item;

public class CoreItems {
	public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(CrazyOres.MODID);
	
	//Overworld ore drops
	public static final CoreRegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot");
	
	public static final CoreRegistryObject<Item> METEORITE_COAL = ITEMS.register("meteorite_coal");
	public static final CoreRegistryObject<Item> METEORITE_GEM = ITEMS.register("meteorite_gem");
	
	public static final CoreRegistryObject<Item> ADAMITE_SHARD = ITEMS.register("adamite_shard");
	public static final CoreRegistryObject<Item> SAPPHIRE_GEM = ITEMS.register("sapphire_gem");
	public static final CoreRegistryObject<Item> RUBY_GEM = ITEMS.register("ruby_gem");
	
	public static final CoreRegistryObject<Item> FOOLS_RUBY_GEM = ITEMS.register("fools_ruby_gem");
	public static final CoreRegistryObject<Item> FOOLS_RUBY_MUSH = ITEMS.register("fools_ruby_mush");
	
	public static final CoreRegistryObject<Item> ZECTIUM_INGOT = ITEMS.register("zectium_ingot");
	public static final CoreRegistryObject<Item> TAPAZITE_OBELISK = ITEMS.register("tapazite_obelisk");
	public static final CoreRegistryObject<Item> TAPAZITE_DUST = ITEMS.register("tapazite_dust");
	public static final CoreRegistryObject<Item> OSMONIUM_INGOT = ITEMS.register("osmonium_ingot");
	public static final CoreRegistryObject<Item> STARCONIUM_GEM = ITEMS.register("starconium_gem");
	public static final CoreRegistryObject<Item> STARCONIUM_SHARD = ITEMS.register("starconium_shard");
	public static final CoreRegistryObject<Item> EXPERIUM_ORB = ITEMS.register("experium_orb");
	
	//Nether ore drops
	public static final CoreRegistryObject<Item> DEMONITE_ORB = ITEMS.register("demonite_orb");
	public static final CoreRegistryObject<Item> INVISIUM_INGOT = ITEMS.register("invisium_ingot");
	
	public static final CoreRegistryObject<Item> DARKSTONE_BAR = ITEMS.register("darkstone_bar");
	
	//Ender ore drops
	public static final CoreRegistryObject<Item> ENDER_GEM = ITEMS.register("ender_gem");
	
	//Items
	public static final CoreRegistryObject<ZectiumCoreItem> ZECTIUM_CORE = ITEMS.register("zectium_core", ZectiumCoreItem::new);

	//Pickaxes
//	public static final CoreRegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe");
//	public static final CoreRegistryObject<Item> METEORITE_PICKAXE = ITEMS.register("meteorite_pickaxe");
//	public static final CoreRegistryObject<Item> ADAMITE_PICKAXE = ITEMS.register("adamite_pickaxe");
//	public static final CoreRegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe");
//	public static final CoreRegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe");
//	public static final CoreRegistryObject<Item> ZECTIUM_PICKAXE = ITEMS.register("zectium_pickaxe");
//	public static final CoreRegistryObject<Item> TAPAZITE_PICKAXE = ITEMS.register("tapazite_pickaxe");
//	public static final CoreRegistryObject<Item> OSMONIUM_PICKAXE = ITEMS.register("osmonium_pickaxe");
//	public static final CoreRegistryObject<Item> STARCONIUM_PICKAXE = ITEMS.register("starconium_pickaxe");
//	public static final CoreRegistryObject<Item> INVISIUM_PICKAXE = ITEMS.register("invisium_pickaxe");
//	public static final CoreRegistryObject<Item> ENDER_PICKAXE = ITEMS.register("ender_pickaxe");
//	
//	/** Axe List **/
//	public static final CoreRegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe");
//	public static final CoreRegistryObject<Item> METEORITE_AXE = ITEMS.register("meteorite_axe");
//	public static final CoreRegistryObject<Item> ADAMITE_AXE = ITEMS.register("adamite_axe");
//	public static final CoreRegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe");
//	public static final CoreRegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe");
//	public static final CoreRegistryObject<Item> ZECTIUM_AXE = ITEMS.register("zectium_axe");
//	public static final CoreRegistryObject<Item> TAPAZITE_AXE = ITEMS.register("tapazite_axe");
//	public static final CoreRegistryObject<Item> OSMONIUM_AXE = ITEMS.register("osmonium_axe");
//	public static final CoreRegistryObject<Item> STARCONIUM_AXE = ITEMS.register("starconium_axe");
//	public static final CoreRegistryObject<Item> INVISIUM_AXE = ITEMS.register("invisium_axe");
//	public static final CoreRegistryObject<Item> ENDER_AXE = ITEMS.register("ender_axe");
//
//	/** Shovel List **/
// 	public static final CoreRegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel");
//	public static final CoreRegistryObject<Item> METEORITE_SHOVEL = ITEMS.register("meteorite_shovel");
//	public static final CoreRegistryObject<Item> ADAMITE_SHOVEL = ITEMS.register("adamite_shovel");
//	public static final CoreRegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel");
//	public static final CoreRegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel");
//	public static final CoreRegistryObject<Item> ZECTIUM_SHOVEL = ITEMS.register("zectium_shovel");
//	public static final CoreRegistryObject<Item> TAPAZITE_SHOVEL = ITEMS.register("tapazite_shovel");
//	public static final CoreRegistryObject<Item> OSMONIUM_SHOVEL = ITEMS.register("osmonium_shovel");
//	public static final CoreRegistryObject<Item> STARCONIUM_SHOVEL = ITEMS.register("starconium_shovel");
//	public static final CoreRegistryObject<Item> INVISIUM_SHOVEL = ITEMS.register("invisium_shovel");
//	public static final CoreRegistryObject<Item> ENDER_SHOVEL = ITEMS.register("ender_shovel");
//
//	/** Sword List **/
//	public static final CoreRegistryObject<Item> METEORITE_SWORD = ITEMS.register("meteorite_sword");
//	public static final CoreRegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword");
//	public static final CoreRegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword");
//	public static final CoreRegistryObject<Item> ADAMITE_SWORD = ITEMS.register("adamite_sword");
//	public static final CoreRegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword");
//	public static final CoreRegistryObject<Item> ZECTIUM_SWORD = ITEMS.register("zectium_sword");
//	public static final CoreRegistryObject<Item> TAPAZITE_SWORD = ITEMS.register("tapazite_sword");
//	public static final CoreRegistryObject<Item> OSMONIUM_SWORD = ITEMS.register("osmonium_sword");
//	public static final CoreRegistryObject<Item> STARCONIUM_SWORD = ITEMS.register("starconium_sword");
//	public static final CoreRegistryObject<Item> INVISIUM_SWORD = ITEMS.register("invisium_sword");
//	public static final CoreRegistryObject<Item> ENDER_SWORD = ITEMS.register("ender_sword");
//	
//	/** Hoe List **/
//	public static final CoreRegistryObject<Item> METEORITE_HOE = ITEMS.register("meteorite_hoe");
//	public static final CoreRegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe");
//	public static final CoreRegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe");
//	public static final CoreRegistryObject<Item> ADAMITE_HOE = ITEMS.register("adamite_hoe");
//	public static final CoreRegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe");
//	public static final CoreRegistryObject<Item> ZECTIUM_HOE = ITEMS.register("zectium_hoe");
//	public static final CoreRegistryObject<Item> TAPAZITE_HOE = ITEMS.register("tapazite_hoe");
//	public static final CoreRegistryObject<Item> OSMONIUM_HOE = ITEMS.register("osmonium_hoe");
//	public static final CoreRegistryObject<Item> STARCONIUM_HOE = ITEMS.register("starconium_hoe");
//	public static final CoreRegistryObject<Item> INVISIUM_HOE = ITEMS.register("invisium_hoe");
//	public static final CoreRegistryObject<Item> ENDER_HOE = ITEMS.register("ender_hoe");
//	
//	/** Hammer List **/
//
//	public static final CoreRegistryObject<Item> STARCONIUM_SLEDGEHAMMER = ITEMS.register("starconium_sledgehammer");
//
//	/** Bucket List **/
//	public static final CoreRegistryObject<Item> COPPER_BUCKET_EMPTY = ITEMS.register("copper_bucket_empty");
//	public static final CoreRegistryObject<Item> COPPER_BUCKET_WATER = ITEMS.register("copper_bucket_water");
//	public static final CoreRegistryObject<Item> COPPER_BUCKET_LAVA = ITEMS.register("copper_bucket_lava");
//	public static final CoreRegistryObject<Item> COPPER_BUCKET_MILK = ITEMS.register("copper_bucket_milk");
//	
//	/** Helmet List **/
//
//	public static final CoreRegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet");
//	public static final CoreRegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet");
//	public static final CoreRegistryObject<Item> ADAMITE_HELMET = ITEMS.register("adamite_helmet");
//	public static final CoreRegistryObject<Item> METEORITE_HELMET = ITEMS.register("meteorite_helmet");
//	public static final CoreRegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet");
//	public static final CoreRegistryObject<Item> ZECTIUM_HELMET = ITEMS.register("zectium_helmet");
//	public static final CoreRegistryObject<Item> TAPAZITE_HELMET = ITEMS.register("tapazite_helmet");
//	public static final CoreRegistryObject<Item> OSMONIUM_HELMET = ITEMS.register("osmonium_helmet");
//	public static final CoreRegistryObject<Item> STARCONIUM_HELMET = ITEMS.register("starconium_helmet");
//	public static final CoreRegistryObject<Item> INVISIUM_HELMET = ITEMS.register("invisium_helmet");
//	public static final CoreRegistryObject<Item> ENDER_HELMET = ITEMS.register("ender_helmet");
//
//	
//	/** Chestplate List **/
//
//	public static final CoreRegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate");
//	public static final CoreRegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate");
//	public static final CoreRegistryObject<Item> ADAMITE_CHESTPLATE = ITEMS.register("adamite_chestplate");
//	public static final CoreRegistryObject<Item> METEORITE_CHESTPLATE = ITEMS.register("meteorite_chestplate");
//	public static final CoreRegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate");
//	public static final CoreRegistryObject<Item> ZECTIUM_CHESTPLATE = ITEMS.register("zectium_chestplate");
//	public static final CoreRegistryObject<Item> TAPAZITE_CHESTPLATE = ITEMS.register("tapazite_chestplate");
//	public static final CoreRegistryObject<Item> OSMONIUM_CHESTPLATE = ITEMS.register("osmonium_chestplate");
//	public static final CoreRegistryObject<Item> STARCONIUM_CHESTPLATE = ITEMS.register("starconium_chestplate");
//	public static final CoreRegistryObject<Item> INVISIUM_CHESTPLATE = ITEMS.register("invisium_chestplate");
//	public static final CoreRegistryObject<Item> ENDER_CHESTPLATE = ITEMS.register("ender_chestplate");
//
//	
//	/** Legging List **/
//
//	public static final CoreRegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings");
//	public static final CoreRegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings");
//	public static final CoreRegistryObject<Item> ADAMITE_LEGGINGS = ITEMS.register("adamite_leggings");
//	public static final CoreRegistryObject<Item> METEORITE_LEGGINGS = ITEMS.register("meteorite_leggings");
//	public static final CoreRegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings");
//	public static final CoreRegistryObject<Item> ZECTIUM_LEGGINGS = ITEMS.register("zectium_leggings");
//	public static final CoreRegistryObject<Item> TAPAZITE_LEGGINGS = ITEMS.register("tapazite_leggings");
//	public static final CoreRegistryObject<Item> OSMONIUM_LEGGINGS = ITEMS.register("osmonium_leggings");
//	public static final CoreRegistryObject<Item> STARCONIUM_LEGGINGS = ITEMS.register("starconium_leggings");
//	public static final CoreRegistryObject<Item> INVISIUM_LEGGINGS = ITEMS.register("invisium_leggings");
//	public static final CoreRegistryObject<Item> ENDER_LEGGINGS = ITEMS.register("ender_leggings");
//
//	
//	/** Boot List **/
//
//	public static final CoreRegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots");	
//	public static final CoreRegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots");
//	public static final CoreRegistryObject<Item> ADAMITE_BOOTS = ITEMS.register("adamite_boots");
//	public static final CoreRegistryObject<Item> METEORITE_BOOTS = ITEMS.register("meteorite_boots");
//	public static final CoreRegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots");
//	public static final CoreRegistryObject<Item> ZECTIUM_BOOTS = ITEMS.register("zectium_boots");
//	public static final CoreRegistryObject<Item> TAPAZITE_BOOTS = ITEMS.register("tapazite_boots");
//	public static final CoreRegistryObject<Item> OSMONIUM_BOOTS = ITEMS.register("osmonium_boots");
//	public static final CoreRegistryObject<Item> STARCONIUM_BOOTS = ITEMS.register("starconium_boots");
//	public static final CoreRegistryObject<Item> INVISIUM_BOOTS = ITEMS.register("invisium_boots");
//	public static final CoreRegistryObject<Item> ENDER_BOOTS = ITEMS.register("ender_boots");
//
//	//Cake!
//	public static final CoreRegistryObject<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake");
//	public static final CoreRegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake");
//	public static final CoreRegistryObject<Item> BIRTHDAY_CAKE = ITEMS.register("birthday_cake");
//	
//	//Custom Spawn Eggs
//	public static final CoreRegistryObject<Item> ZECTIUM_PROTECTOR_EGG = ITEMS.register("zectium_protector_egg");
//	public static final CoreRegistryObject<Item> GREAT_WHITE_SHARK_EGG = ITEMS.register("great_white_shark_egg");
//	public static final CoreRegistryObject<Item> ADAMITE_SHARK_EGG = ITEMS.register("adamite_shark_egg");
//	
//	/** Bow List **/
//
//	public static final CoreRegistryObject<Item> SWIFT_BOW = ITEMS.register("swift_bow");
//	public static final CoreRegistryObject<Item> HELL_BOW = ITEMS.register("hell_bow");
//	public static final CoreRegistryObject<Item> DUAL_SHOT_BOW = ITEMS.register("dual_shot_bow");
//	public static final CoreRegistryObject<Item> CONFUSION_BOW = ITEMS.register("confusion_bow");
	
	/** Arrow List **/
	
	public static final CoreRegistryObject<Item> FLAMING_ARROW = ITEMS.register("flaming_arrow");
	public static final CoreRegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow");
	public static final CoreRegistryObject<Item> FREEZING_ARROW = ITEMS.register("frozen_arrow");
	public static final CoreRegistryObject<Item> LIGHTNING_ARROW = ITEMS.register("lightning_arrow");
	
	/** Arrow_Head List **/
	
	public static final CoreRegistryObject<Item> FLAMING_ARROW_HEAD = ITEMS.register("flaming_arrow_head");
	public static final CoreRegistryObject<Item> EXPLOSIVE_ARROW_HEAD = ITEMS.register("explosive_arrow_head");
	public static final CoreRegistryObject<Item> FROZEN_ARROW_HEAD = ITEMS.register("frozen_arrow_head");
	public static final CoreRegistryObject<Item> LIGHTNING_ARROW_HEAD = ITEMS.register("lightning_arrow_head");

//	public static final CoreRegistryObject<Item> RAW_SHARK_MEAT = ITEMS.register("raw_shark_meat");
//	public static final CoreRegistryObject<Item> COOKED_SHARK_MEAT = ITEMS.register("cooked_shark_meat");
//	
//	public static final CoreRegistryObject<Item> LUMINITE_CRYSTAL = ITEMS.register("luminite_crystal");
//	public static final CoreRegistryObject<Item> LIGHTENED_BRICK_ITEM = ITEMS.register("lightened_brick_item");
}
