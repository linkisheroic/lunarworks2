package com.rose.lunarworks.blocks;

import com.rose.lunarworks.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLunarTank extends Block implements ITileEntityProvider {

	public BlockLunarTank() {
		super(Material.GLASS);
		this.setUnlocalizedName("lunarTank");
		this.setRegistryName("lunar_tank");
		this.setCreativeTab(ModItems.tabLunarworks);
	}
	
	@Override
	public boolean hasTileEntity() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityLunarTank();
	}
	
	private TileEntityLunarTank getTE(IBlockAccess world, BlockPos pos) {
        return (TileEntityLunarTank) world.getTileEntity(pos);
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
		if (tileentity instanceof TileEntityLunarTank)
		{
			((TileEntityLunarTank)tileentity).setPos(pos);
			worldIn.scheduleBlockUpdate(pos, this, 2, 1); // schedule first update
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

}
