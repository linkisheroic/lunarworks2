package com.rose.lunarworks.proxy;

import com.rose.lunarworks.ModelHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(ModelHandler.class);
    }

	@Override
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
    	
    }

	@Override
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	
    }

}
