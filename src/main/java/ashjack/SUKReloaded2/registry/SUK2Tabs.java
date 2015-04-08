package ashjack.SUKReloaded2.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SUK2Tabs 
{
	public static CreativeTabs tabSUK2 = new CreativeTabs("tabSUK2") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(SUK2Blocks.constructorBlock);
	    }
	};
}
