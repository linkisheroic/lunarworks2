package com.rose.lunarworks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static com.rose.lunarworks.blocks.ModBlocks.*;
import static com.rose.lunarworks.items.ModItems.*;

@SideOnly(Side.CLIENT)
public class ModelHandler {

	@SubscribeEvent
	public static void handleModelRegistry(ModelRegistryEvent event)
	{
		itemModels();
		blockModels();
	}
	
	private static void itemModels()
	{
		register(silverIngot);
		register(silverNugget);
		
		register(silverSword);
		register(silverAxe);
		register(silverPickaxe);
		register(silverShovel);
		register(silverHoe);
	}
	
	private static void blockModels()
	{
		register(silverOre);
		register(silverBlock);
	}
	
	private static void register(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Item.REGISTRY.getNameForObject(item), "inventory"));
	}
	
	private static void register(Block block)
	{
		register(Item.getItemFromBlock(block));
	}
	
}