package com.rose.lunarworks.fluids;

import com.rose.lunarworks.Lunarworks;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidLun extends Fluid {

	FluidLun() {
		super("lun", new ResourceLocation(Lunarworks.MODID, "fluids/lun_still"), new ResourceLocation(Lunarworks.MODID, "fluids/lun_flow"));
		FluidRegistry.registerFluid(this);
	}
	
}
