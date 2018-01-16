package com.rose.lunarworks;

import com.rose.lunarworks.blocks.ModBlocks;
import com.rose.lunarworks.blocks.TileEntityLunarCondenser;
import com.rose.lunarworks.items.ModItems;
import com.rose.lunarworks.proxy.CommonProxy;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Lunarworks.MODID, name = Lunarworks.MODNAME, version = Lunarworks.VERSION, useMetadata = true)
public class Lunarworks {

	public static final String MODID = "lunarworks";
    public static final String MODNAME = "Lunarworks";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "com.rose.lunarworks.proxy.ClientProxy", serverSide = "com.rose.lunarworks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static Lunarworks instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event); 
    	MinecraftForge.EVENT_BUS.register(ModBlocks.class);
    	MinecraftForge.EVENT_BUS.register(ModItems.class);
    	GameRegistry.registerWorldGenerator(new WorldGenOres(), 3);
		GameRegistry.registerTileEntity(TileEntityLunarCondenser.class, Lunarworks.MODID + "_lunar_condenser");
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    	SmeltingRecipes.init();
    	OreDictionary.registerOre("oreSilver", ModBlocks.silverOre);
    	OreDictionary.registerOre("ingotSilver", ModItems.silverIngot);
    	OreDictionary.registerOre("nuggetSilver", ModItems.silverNugget);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
	
}
