package ashjack.SUKReloaded2.core;

import java.io.File;

public class SUK2IO 
{
	public static String getSimukraftFolder()
	{
		try
		{
			String strmc = new File(".").getAbsolutePath();
			strmc = strmc.substring(0, strmc.length() - 1);
			return new File(strmc + File.separator + "mods" + File.separator + "Simukraft").getAbsolutePath();
		}
		catch (Exception e)
		{
			return "";
		}
	}
}
