package ashjack.SUKReloaded2.registry;

import net.minecraft.block.Block;
import ashjack.SUKReloaded2.blocks.BlockConstructorBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class SUK2Blocks 
{
	public static Block constructorBlock;
	
	public static void loadBlocks()
	{
		constructorBlock = new BlockConstructorBlock();
		registerBlocks();
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(constructorBlock, "SUK2_ConstructorBlock");
	}
}
