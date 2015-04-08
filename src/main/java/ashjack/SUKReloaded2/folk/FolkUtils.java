package ashjack.SUKReloaded2.folk;

import ashjack.SUKReloaded2.core.SUK2Log;
import ashjack.SUKReloaded2.entity.EntityFolk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class FolkUtils
{
	public static void generateFolk(World world)
	{
		EntityFolk theFolk = new EntityFolk(world);  
		EntityPlayer thePlayer = (EntityPlayer) world.playerEntities.get(0);
		theFolk.setPosition(thePlayer.posX, thePlayer.posY, thePlayer.posZ); 
		SUK2Log.log.info(String.valueOf(thePlayer.posX + ", " + thePlayer.posY + ", " + thePlayer.posZ));
		world.spawnEntityInWorld(theFolk); 
	}
}
