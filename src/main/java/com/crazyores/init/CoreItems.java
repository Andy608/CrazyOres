package com.crazyores.init;

import com.crazyores.CrazyOres;
import com.crazyores.init.registration.CoreRegistryObject;
import com.crazyores.init.registration.ItemDeferredRegister;
import com.crazyores.item.CoreAxe;
import com.crazyores.item.CoreHoe;
import com.crazyores.item.CorePickaxe;
import com.crazyores.item.CoreShovel;
import com.crazyores.item.CoreSword;
import com.crazyores.item.CrazyTiers;
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
	public static final CoreRegistryObject<CorePickaxe> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new CorePickaxe(CrazyTiers.COPPER));
	public static final CoreRegistryObject<CorePickaxe> METEORITE_PICKAXE = ITEMS.register("meteorite_pickaxe", () -> new CorePickaxe(CrazyTiers.METEORITE));
	public static final CoreRegistryObject<CorePickaxe> ADAMITE_PICKAXE = ITEMS.register("adamite_pickaxe", () -> new CorePickaxe(CrazyTiers.ADAMITE));
	public static final CoreRegistryObject<CorePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new CorePickaxe(CrazyTiers.SAPPHIRE));
	public static final CoreRegistryObject<CorePickaxe> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new CorePickaxe(CrazyTiers.RUBY));
	public static final CoreRegistryObject<CorePickaxe> ZECTIUM_PICKAXE = ITEMS.register("zectium_pickaxe", () -> new CorePickaxe(CrazyTiers.ZECTIUM));
	public static final CoreRegistryObject<CorePickaxe> TAPAZITE_PICKAXE = ITEMS.register("tapazite_pickaxe", () -> new CorePickaxe(CrazyTiers.TAPAZITE));
	public static final CoreRegistryObject<CorePickaxe> OSMONIUM_PICKAXE = ITEMS.register("osmonium_pickaxe", () -> new CorePickaxe(CrazyTiers.OSMONIUM));
	public static final CoreRegistryObject<CorePickaxe> STARCONIUM_PICKAXE = ITEMS.register("starconium_pickaxe", () -> new CorePickaxe(CrazyTiers.STARCONIUM));
	public static final CoreRegistryObject<CorePickaxe> INVISIUM_PICKAXE = ITEMS.register("invisium_pickaxe", () -> new CorePickaxe(CrazyTiers.INVISIUM));
	public static final CoreRegistryObject<CorePickaxe> ENDER_PICKAXE = ITEMS.register("ender_pickaxe", () -> new CorePickaxe(CrazyTiers.ENDER));
	
	/** Axe List **/
	public static final CoreRegistryObject<CoreAxe> COPPER_AXE = ITEMS.register("copper_axe", () -> new CoreAxe(CrazyTiers.COPPER));
	public static final CoreRegistryObject<CoreAxe> METEORITE_AXE = ITEMS.register("meteorite_axe", () -> new CoreAxe(CrazyTiers.METEORITE));
	public static final CoreRegistryObject<CoreAxe> ADAMITE_AXE = ITEMS.register("adamite_axe", () -> new CoreAxe(CrazyTiers.ADAMITE));
	public static final CoreRegistryObject<CoreAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new CoreAxe(CrazyTiers.SAPPHIRE));
	public static final CoreRegistryObject<CoreAxe> RUBY_AXE = ITEMS.register("ruby_axe", () -> new CoreAxe(CrazyTiers.RUBY));
	public static final CoreRegistryObject<CoreAxe> ZECTIUM_AXE = ITEMS.register("zectium_axe", () -> new CoreAxe(CrazyTiers.ZECTIUM));
	public static final CoreRegistryObject<CoreAxe> TAPAZITE_AXE = ITEMS.register("tapazite_axe", () -> new CoreAxe(CrazyTiers.TAPAZITE));
	public static final CoreRegistryObject<CoreAxe> OSMONIUM_AXE = ITEMS.register("osmonium_axe", () -> new CoreAxe(CrazyTiers.OSMONIUM));
	public static final CoreRegistryObject<CoreAxe> STARCONIUM_AXE = ITEMS.register("starconium_axe", () -> new CoreAxe(CrazyTiers.STARCONIUM));
	public static final CoreRegistryObject<CoreAxe> INVISIUM_AXE = ITEMS.register("invisium_axe", () -> new CoreAxe(CrazyTiers.INVISIUM));
	public static final CoreRegistryObject<CoreAxe> ENDER_AXE = ITEMS.register("ender_axe", () -> new CoreAxe(CrazyTiers.ENDER));

	/** Shovel List **/
 	public static final CoreRegistryObject<CoreShovel> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new CoreShovel(CrazyTiers.COPPER));
	public static final CoreRegistryObject<CoreShovel> METEORITE_SHOVEL = ITEMS.register("meteorite_shovel", () -> new CoreShovel(CrazyTiers.METEORITE));
	public static final CoreRegistryObject<CoreShovel> ADAMITE_SHOVEL = ITEMS.register("adamite_shovel", () -> new CoreShovel(CrazyTiers.ADAMITE));
	public static final CoreRegistryObject<CoreShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new CoreShovel(CrazyTiers.SAPPHIRE));
	public static final CoreRegistryObject<CoreShovel> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new CoreShovel(CrazyTiers.RUBY));
	public static final CoreRegistryObject<CoreShovel> ZECTIUM_SHOVEL = ITEMS.register("zectium_shovel", () -> new CoreShovel(CrazyTiers.ZECTIUM));
	public static final CoreRegistryObject<CoreShovel> TAPAZITE_SHOVEL = ITEMS.register("tapazite_shovel", () -> new CoreShovel(CrazyTiers.TAPAZITE));
	public static final CoreRegistryObject<CoreShovel> OSMONIUM_SHOVEL = ITEMS.register("osmonium_shovel", () -> new CoreShovel(CrazyTiers.OSMONIUM));
	public static final CoreRegistryObject<CoreShovel> STARCONIUM_SHOVEL = ITEMS.register("starconium_shovel", () -> new CoreShovel(CrazyTiers.STARCONIUM));
	public static final CoreRegistryObject<CoreShovel> INVISIUM_SHOVEL = ITEMS.register("invisium_shovel", () -> new CoreShovel(CrazyTiers.INVISIUM));
	public static final CoreRegistryObject<CoreShovel> ENDER_SHOVEL = ITEMS.register("ender_shovel", () -> new CoreShovel(CrazyTiers.ENDER));

	/** Sword List **/
	public static final CoreRegistryObject<CoreSword> METEORITE_SWORD = ITEMS.register("meteorite_sword", () -> new CoreSword(CrazyTiers.METEORITE));
	public static final CoreRegistryObject<CoreSword> COPPER_SWORD = ITEMS.register("copper_sword", () -> new CoreSword(CrazyTiers.COPPER));
	public static final CoreRegistryObject<CoreSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new CoreSword(CrazyTiers.SAPPHIRE));
	public static final CoreRegistryObject<CoreSword> ADAMITE_SWORD = ITEMS.register("adamite_sword", () -> new CoreSword(CrazyTiers.ADAMITE));
	public static final CoreRegistryObject<CoreSword> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new CoreSword(CrazyTiers.RUBY));
	public static final CoreRegistryObject<CoreSword> ZECTIUM_SWORD = ITEMS.register("zectium_sword", () -> new CoreSword(CrazyTiers.ZECTIUM));
	public static final CoreRegistryObject<CoreSword> TAPAZITE_SWORD = ITEMS.register("tapazite_sword", () -> new CoreSword(CrazyTiers.TAPAZITE));
	public static final CoreRegistryObject<CoreSword> OSMONIUM_SWORD = ITEMS.register("osmonium_sword", () -> new CoreSword(CrazyTiers.OSMONIUM));
	public static final CoreRegistryObject<CoreSword> STARCONIUM_SWORD = ITEMS.register("starconium_sword", () -> new CoreSword(CrazyTiers.STARCONIUM));
	public static final CoreRegistryObject<CoreSword> INVISIUM_SWORD = ITEMS.register("invisium_sword", () -> new CoreSword(CrazyTiers.INVISIUM));
	public static final CoreRegistryObject<CoreSword> ENDER_SWORD = ITEMS.register("ender_sword", () -> new CoreSword(CrazyTiers.ENDER));
	
	/** Hoe List **/
	public static final CoreRegistryObject<CoreHoe> METEORITE_HOE = ITEMS.register("meteorite_hoe", () -> new CoreHoe(CrazyTiers.METEORITE, -1.5F));
	public static final CoreRegistryObject<CoreHoe> COPPER_HOE = ITEMS.register("copper_hoe", () -> new CoreHoe(CrazyTiers.COPPER, -1.5F));
	public static final CoreRegistryObject<CoreHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new CoreHoe(CrazyTiers.SAPPHIRE));
	public static final CoreRegistryObject<CoreHoe> ADAMITE_HOE = ITEMS.register("adamite_hoe", () -> new CoreHoe(CrazyTiers.ADAMITE, -0.5F));
	public static final CoreRegistryObject<CoreHoe> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new CoreHoe(CrazyTiers.RUBY));
	public static final CoreRegistryObject<CoreHoe> ZECTIUM_HOE = ITEMS.register("zectium_hoe", () -> new CoreHoe(CrazyTiers.ZECTIUM));
	public static final CoreRegistryObject<CoreHoe> TAPAZITE_HOE = ITEMS.register("tapazite_hoe", () -> new CoreHoe(CrazyTiers.TAPAZITE));
	public static final CoreRegistryObject<CoreHoe> OSMONIUM_HOE = ITEMS.register("osmonium_hoe", () -> new CoreHoe(CrazyTiers.OSMONIUM));
	public static final CoreRegistryObject<CoreHoe> STARCONIUM_HOE = ITEMS.register("starconium_hoe", () -> new CoreHoe(CrazyTiers.STARCONIUM));
	public static final CoreRegistryObject<CoreHoe> INVISIUM_HOE = ITEMS.register("invisium_hoe", () -> new CoreHoe(CrazyTiers.INVISIUM));
	public static final CoreRegistryObject<CoreHoe> ENDER_HOE = ITEMS.register("ender_hoe", () -> new CoreHoe(CrazyTiers.ENDER));
	
	/** Hammer List **/

//	public static final CoreRegistryObject<Item> STARCONIUM_SLEDGEHAMMER = ITEMS.register("starconium_sledgehammer");

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
