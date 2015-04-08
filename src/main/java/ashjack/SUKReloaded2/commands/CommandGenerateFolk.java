package ashjack.SUKReloaded2.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import ashjack.SUKReloaded2.folk.FolkData;

public class CommandGenerateFolk implements ICommand
{ 
    private final List aliases;
    
    FolkData theFolk;
  
    public CommandGenerateFolk() 
    { 
        aliases = new ArrayList(); 
        aliases.add("generatefolk"); 
        aliases.add("generatesim"); 
    } 
  
    @Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getCommandName() 
    { 
        return "generatefolk"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return "/generatefolk"; 
    } 

    @Override 
    public List getCommandAliases() 
    { 
        return this.aliases;
    } 

    @Override 
    public void processCommand(ICommandSender sender, String[] argString)
    { 
        World world = sender.getEntityWorld(); 
    
        if (world.isRemote) 
        { 
            System.out.println("Not processing on Client side"); 
        } 
        else 
        { 
            System.out.println("Processing on Server side"); 
            if(argString.length > 0) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument")); 
                return; 
            } 
            
            /*theFolk = new EntityFolk(world);
            theFolk.setPosition(sender.getPlayerCoordinates().posX,       
            sender.getPlayerCoordinates().posY, 
            sender.getPlayerCoordinates().posZ); 
            world.spawnEntityInWorld(theFolk); */
            
            theFolk = new FolkData(sender.getEntityWorld());
        } 
    } 

    @Override 
    public boolean canCommandSenderUseCommand(ICommandSender var1) 
    { 
        return true;
    } 

    @Override  
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        // TODO Auto-generated method stub 
        return null; 
    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        // TODO Auto-generated method stub 
        return false;
    } 
}