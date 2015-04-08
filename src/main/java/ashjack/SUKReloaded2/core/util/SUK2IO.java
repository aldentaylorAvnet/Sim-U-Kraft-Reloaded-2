package ashjack.SUKReloaded2.core.util;

import java.io.File;

public class SUK2IO 
{
	public static String getSimukraftFolder()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			return new File(strmc + File.separator + "Simukraft_Reloaded").getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static String getSimukraftFolder(String subCategory)
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			return new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + subCategory).getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static String getTempFolder()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			if(new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp").exists())
			{
				return new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp").getAbsolutePath();
			}
			new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp").mkdir();
			return new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp").getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static String getTempFolder(String subCategory)
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			
			File theFile = new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp" + File.separator + "assets" + File.separator + "suk2" + File.separator + "textures" + File.separator + subCategory);
			
			if(theFile.exists())
			{
				return theFile.getAbsolutePath();
			}
			theFile.mkdir();
			return theFile.getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static String getTempOrigin()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			
			File theFile = new File(strmc + File.separator + "Simukraft_Reloaded" + File.separator + ".temp");
			
			if(theFile.exists())
			{
				return theFile.getAbsolutePath();
			}
			theFile.mkdir();
			return theFile.getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static String getModsFolder()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			return new File(strmc + File.separator + "mods").getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static File getSUK2ModJar()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			File modsFolder = new File(strmc + File.separator + "mods");
			File[] mods = modsFolder.listFiles();
			
			for(int i = 0; i<mods.length; i++)
			{
				if(mods[i].getName().contains("SUK2"))
				{
					return mods[i];
				}
			}
			return null;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
