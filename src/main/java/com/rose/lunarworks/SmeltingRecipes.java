package com.rose.lunarworks;

import com.rose.lunarworks.blocks.ModBlocks;
import com.rose.lunarworks.items.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes {

	public static void init() {
		
		GameRegistry.addSmelting(ModBlocks.silverOre, new ItemStack(ModItems.silverIngot), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ModItems.silverHelmet), new ItemStack(ModItems.silverNugget), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModItems.silverChestplate), new ItemStack(ModItems.silverNugget), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModItems.silverLeggings), new ItemStack(ModItems.silverNugget), 0.5F);
		GameRegistry.addSmelting(new ItemStack(ModItems.silverBoots), new ItemStack(ModItems.silverNugget), 0.5F);
	}
}