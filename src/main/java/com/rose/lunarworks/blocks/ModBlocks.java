package com.rose.lunarworks.blocks;

import com.rose.lunarworks.Lunarworks;
import com.rose.lunarworks.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static Block silverOre = new BlockSilverOre().setCreativeTab(ModItems.tabLunarworks);
	public static Block silverBlock = new Block(Material.IRON).setHardness(4.0F).setResistance(6.0F).setUnlocalizedName("silverBlock").setRegistryName("silver_block").setCreativeTab(ModItems.tabLunarworks);
	public static Block lunarCondenser = new BlockLunarCondenser().setCreativeTab(ModItems.tabLunarworks);
	public static Block lunarTank = new BlockLunarTank().setHardness(2.0F).setResistance(2.0F);
	
	//Register Blocks
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		
		registry.register(silverOre);
		registry.register(silverBlock);
		registry.register(lunarCondenser);
		registry.register(lunarTank);
	}
	
}
