package ashjack.SUKReloaded2.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ashjack.SUKReloaded2.folk.FolkData;

public class EntityFolk extends EntityCreature implements INpc
{

	FolkData theFolk = null;
	public ResourceLocation textureLocation = null;
	
	public EntityFolk(World p_i1602_1_) 
	{
		super(p_i1602_1_);
		setSize(0.6F, 1.8F);
		this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setEnterDoors(true);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(10, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.tasks.addTask(9, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.3D));
		this.tasks.addTask(4, new EntityAISwimming(this));
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    }
	
	public boolean isAIEnabled()
	{
		 return true;
	}

}
