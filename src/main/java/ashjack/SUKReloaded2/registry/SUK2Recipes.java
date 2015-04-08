package ashjack.SUKReloaded2.registry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SUK2Recipes 
{
	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(SUK2Blocks.constructorBlock), new Object[]{
	    	"WWW",
	    	"CTC",
	    	"CCC",
	    	'W', Blocks.planks, 'C', Blocks.cobblestone, 'T', Blocks.crafting_table
	    	});
	}
}
