package ashjack.SUKReloaded2.folk;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import net.minecraft.util.ResourceLocation;
import ashjack.SUKReloaded2.core.util.SUK2IO;

public class Race 
{
	public static String raceName = "";
	public static String raceDesc = "";
	public static int raceLifespan = 110;
	public static int raceMaturity = 18;
	
	public int skinNumber = 0;
		
	public Race(String name, String desc, int skinNo)
	{
		this.raceName = name;
		this.raceDesc = desc;
		this.skinNumber = skinNo;
	}
	
	public Race(String name, String desc, int lifespan, int maturity, int skinNo)
	{
		this.raceName = name;
		this.raceDesc = desc;
		this.raceLifespan = lifespan;
		this.raceMaturity = maturity;
		this.skinNumber = skinNo;
	}
	
	public static Race assignRandomRace()
	{
		String randName = raceName;
		String randDesc = raceDesc;
		int randSpan = raceLifespan;
		int randMat = raceMaturity;
		
		File race = raceFiles[0];
		
		try
		{
			FileInputStream fstream = new FileInputStream(race.getAbsolutePath());
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			for(String line; (line = br.readLine()) != null; )
			{
				String[] commands = line.split("=");
				
				if(commands[0].contains("name"))
				{
					randName = commands[1];
				}
				if(commands[0].contains("desc"))
				{
					randDesc = commands[1];
				}
				if(commands[0].contains("lifespan"))
				{
					randSpan = Integer.parseInt(commands[1]);
				}
				if(commands[0].contains("maturity"))
				{
					randMat = Integer.parseInt(commands[1]);
				}
			}
			
			br.close();
		}
		catch(IOException e)
		{
			
		}
		
		return new Race(randName, randDesc, randSpan, randMat, rand.nextInt(raceSkinFiles.length));
	}
	
	public ResourceLocation getSkinPath(int id)
	{
		return new ResourceLocation("SUK2", "Races/" + this.raceName + "/" + raceSkinFiles[id].getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static Random rand = new Random();
	static File raceFolder = new File(SUK2IO.getSimukraftFolder("Races"));
	
	static File[] racesFolders = raceFolder.listFiles(new FileFilter(){
		public boolean accept(File file) {
			return file.isDirectory();
		}
	});
	
	static File[] raceFiles = racesFolders[rand.nextInt(racesFolders.length-1)].listFiles(new FilenameFilter() 
	{
	    public boolean accept(File dir, String name) 
	    {
	        return name.toLowerCase().endsWith(".suk2race");
	    }
	});
	
	public static File[] raceSkinFiles = racesFolders[rand.nextInt(racesFolders.length-1)].listFiles(new FilenameFilter() 
	{
	    public boolean accept(File dir, String name) 
	    {
	        return name.toLowerCase().endsWith(".png");
	    }
	});
}
