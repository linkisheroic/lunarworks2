package com.rose.lunarworks.blocks;

import java.awt.TextComponent;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.Int;

public class BlockLunarCondenser extends Block implements ITileEntityProvider {

	public BlockLunarCondenser() {
		super(Material.IRON);
		this.setUnlocalizedName("lunarCondenser");
		this.setRegistryName("lunar_condenser");
	}
	
	@Override
	public boolean hasTileEntity() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityLunarCondenser();
	}
	
	private TileEntityLunarCondenser getTE(IBlockAccess world, BlockPos pos) {
        return (TileEntityLunarCondenser) world.getTileEntity(pos);
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
        		// We only count on the server side.
                int lunStorageCurrent = getTE(world, pos).getLunStorage();
                ITextComponent message = new TextComponentTranslation(String.valueOf(lunStorageCurrent));
                player.sendStatusMessage(message, false);
        }
        // Return true also on the client to make sure that MC knows we handled this and will not try to place
        // a block on the client
        return true;
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof TileEntityLunarCondenser)
		{
			((TileEntityLunarCondenser)tileentity).setPos(pos);
			worldIn.scheduleBlockUpdate(pos, this, 2, 1); // schedule first update
		}
	}
		
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{	
		if(!worldIn.isRemote) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityLunarCondenser){
				((TileEntityLunarCondenser)tileentity).update();      //call jdwupDate in tile entity
				worldIn.scheduleBlockUpdate(pos, this, 2, 1);   //schedule next update. 
			}
	    }	
	}

}
