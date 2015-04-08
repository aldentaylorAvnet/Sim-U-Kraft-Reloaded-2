package ashjack.SUKReloaded2.core;

import java.util.logging.Logger;

import ashjack.SUKReloaded2.core.proxy.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SUK2Log 
{
	@SideOnly(Side.CLIENT)
	public static Logger log = ClientProxy.log;
}
