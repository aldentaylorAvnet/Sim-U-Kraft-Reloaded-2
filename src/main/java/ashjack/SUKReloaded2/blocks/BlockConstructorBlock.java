package ashjack.SUKReloaded2.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ashjack.SUKReloaded2.core.SUK2;
import ashjack.SUKReloaded2.registry.SUK2Tabs;

public class BlockConstructorBlock extends Block
{

	public BlockConstructorBlock() 
	{
		super(Material.wood);
		setBlockName("SUK2_ConstructorBlock");
		setBlockTextureName(SUK2.MODID + ":" + "constructorBlock");
		setCreativeTab(SUK2Tabs.tabSUK2);
	}

}
