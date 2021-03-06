package ashjack.SUKReloaded2.core.proxy;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.world.World;
import ashjack.SUKReloaded2.core.util.ExternalTextureLoader;
import ashjack.SUKReloaded2.entity.EntityFolk;
import ashjack.SUKReloaded2.entity.RenderFolk;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	public World getClientWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}
	
	@SideOnly(Side.CLIENT)
	public static Logger log = Logger.getLogger("Sim-U-Kraft Reloaded");

	@SideOnly(Side.CLIENT)
	public void setLogLevel()
	{
		log.setLevel(Level.INFO);
	}

	
	@Override
    public void preInit(FMLPreInitializationEvent event) 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityFolk.class, new RenderFolk(new ModelBiped(), 0.5F));
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) 
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) 
    {
		ExternalTextureLoader.pushTextures();
		super.postInit(event);
    }
}
