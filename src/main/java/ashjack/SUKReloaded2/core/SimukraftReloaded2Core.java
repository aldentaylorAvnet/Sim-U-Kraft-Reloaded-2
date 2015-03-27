package ashjack.SUKReloaded2.core;

import ashjack.SUKReloaded2.core.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimukraftReloaded2Core.MODID, version = SimukraftReloaded2Core.VERSION)
public class SimukraftReloaded2Core
{
    public static final String MODID = "SUKReloaded2";
    public static final String VERSION = "2.0.0";
    
    @SidedProxy(clientSide="ashjack.SUKReloaded2.core.proxy.ClientProxy", 
    		    serverSide="ashjack.SUKReloaded2.core.proxy.ServerProxy")
    
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
		
    }
}
