package com.rose.lunarworks.blocks;

import net.minecraft.util.ITickable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLunarCondenser extends TileEntity implements ITickable {

	private boolean moon = false;
	private boolean canSeeSky = false;
	
	private int lunStorage = 0;
	
	public boolean isUnderSky() {
        return canSeeSky;
    }
	
	public boolean isMoonOut() {
		return moon;
	}
	
	public int getLunStorage() {
		return lunStorage;
	}
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		world.scheduleBlockUpdate(pos, world.getBlockState(pos).getBlock(), 2, 1);;
	}
	
	@Override
	public void update() {
		if(world.canBlockSeeSky(pos) && !world.isDaytime()) {
			lunStorage += 10;
		}	
		
		System.out.println("fuck");
		
			if(world.canSeeSky(pos)) {
				canSeeSky = true;
			}
			
			else if(!world.canSeeSky(pos)) {
				canSeeSky = false;
			}
			
			if(world.getMoonPhase() != 0) {
				moon = true;
			}
			
			else if(world.getMoonPhase() == 0) {
				moon = false;
			}
			
			if(lunStorage > 3000) {
				lunStorage = 3000;
			}
	}
	
	 	@Override
	    public void readFromNBT(NBTTagCompound compound) {
	        super.readFromNBT(compound);
	        lunStorage = compound.getInteger("lunStorage");
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	        super.writeToNBT(compound);
	        compound.setInteger("lunStorage", lunStorage);
	        return compound;
	   }
}
