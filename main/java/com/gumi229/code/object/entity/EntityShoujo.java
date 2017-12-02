package com.gumi229.code.object.entity;

import com.gumi229.code.object.entity.ai.EntityAIShoujoAttackArmRaised;
import com.gumi229.code.until.Global;
import com.gumi229.code.until.ProgrammingParadigm;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShoujo extends EntityMob {
	/**
	 * For arms raised when attack I DO NOT KNOW why it is STATIC?
	 */
	static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>createKey(EntityZombie.class,
			DataSerializers.BOOLEAN);

	final ProgrammingParadigm type;

	public EntityShoujo(World worldIn, ProgrammingParadigm type) {
		super(worldIn);
		this.type = type;
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAIShoujoAttackArmRaised(this, 1.0d, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0d));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0d));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, this.getClass(), 8.0f));
		this.tasks.addTask(10, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		Global.logger.info("Init Entity AI Success!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataManager().register(ARMS_RAISED, Boolean.valueOf(false));
	}

	public ProgrammingParadigm getType() {
		return type;
	}

	public void setArmsRaised(boolean armsRaised) {
		this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(armsRaised));
	}

	@SideOnly(Side.CLIENT)
	public boolean getArmsRaised() {
		return this.getDataManager().get(ARMS_RAISED).booleanValue();
	}

}
