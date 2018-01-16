package com.rose.lunarworks.items;

import com.rose.lunarworks.Lunarworks;
import com.rose.lunarworks.blocks.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final CreativeTabs tabLunarworks = new CreativeTabs("tabLunarworks")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(silverIngot);
		}
	};
	
   public static final Item.ToolMaterial silver = EnumHelper.addToolMaterial("SILVER", 2, 200, 6.0F, 2.0F, 16);
   public static final ItemArmor.ArmorMaterial silverArmor = EnumHelper.addArmorMaterial("silver", Lunarworks.MODID + ":silver", 200, new int[]{1, 4, 5, 1}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

   public static Item silverIngot = new Item().setUnlocalizedName("silverIngot").setRegistryName("silver_ingot").setCreativeTab(tabLunarworks);
   public static Item silverNugget = new Item().setUnlocalizedName("silverNugget").setRegistryName("silver_nugget").setCreativeTab(tabLunarworks);

   public static Item silverSword = new ItemSword(silver).setUnlocalizedName("silverSword").setRegistryName("silver_sword").setCreativeTab(tabLunarworks);
   public static Item silverPickaxe = new ItemSilverPickaxe(silver).setCreativeTab(tabLunarworks);
   public static Item silverShovel = new ItemSilverShovel(silver).setCreativeTab(tabLunarworks);
   public static Item silverAxe = new ItemSilverAxe(silver).setCreativeTab(tabLunarworks);
   public static Item silverHoe = new ItemSilverHoe(silver).setCreativeTab(tabLunarworks);

   public static Item silverHelmet = new ItemArmor(silverArmor, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("silverHelmet").setRegistryName("silver_helmet").setCreativeTab(tabLunarworks);
   public static Item silverChestplate = new ItemArmor(silverArmor, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("silverChestplate").setRegistryName("silver_chestplate").setCreativeTab(tabLunarworks);
   public static Item silverLeggings = new ItemArmor(silverArmor, 2, EntityEquipmentSlot.LEGS).setUnlocalizedName("silverLeggings").setRegistryName("silver_leggings").setCreativeTab(tabLunarworks);
   public static Item silverBoots = new ItemArmor(silverArmor, 3, EntityEquipmentSlot.FEET).setUnlocalizedName("silverBoots").setRegistryName("silver_boots").setCreativeTab(tabLunarworks);
   
   
	//Register Items
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(silverIngot);
		registry.register(silverNugget);
		
		registry.register(silverSword);
		registry.register(silverAxe);
		registry.register(silverPickaxe);
		registry.register(silverShovel);
		registry.register(silverHoe);
		
		registry.register(silverHelmet);
		registry.register(silverChestplate);
		registry.register(silverLeggings);
		registry.register(silverBoots);
		
		registerItemBlock(registry, new ItemBlock(ModBlocks.silverOre));
		registerItemBlock(registry, new ItemBlock(ModBlocks.silverBlock));
		registerItemBlock(registry, new ItemBlock(ModBlocks.lunarCondenser));
		registerItemBlock(registry, new ItemBlock(ModBlocks.lunarTank));
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, ItemBlock item)
	{
		registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
		return item;
	}
}
