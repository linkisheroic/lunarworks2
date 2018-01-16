package com.rose.lunarworks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSilverOre extends Block {

		public BlockSilverOre() {
			super(Material.ROCK);
			this.setUnlocalizedName("silverOre");
			this.setRegistryName("silver_ore");
			setHardness(3f);
			setResistance(5f);
			this.setHarvestLevel("pickaxe", 2);
		}
}
