package com.rose.lunarworks.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLunarTank extends TileEntity {
	
	private int lunStorage = 0;
	private final int maxStorage = 10000;
	
	private boolean outputConnection = false;
	private boolean inputConnection = false;
	
	public int getLunStorage() {
		return lunStorage;
	}
	
	public int decreaseLun(int amount) {
		if(lunStorage - amount >= 0) {
			lunStorage = lunStorage - amount;
		}
		return lunStorage;
	}
	
	public int increaseLun(int amount) {
		if(lunStorage + amount <= maxStorage) {
			lunStorage = lunStorage + amount;
		}
		return lunStorage;
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
