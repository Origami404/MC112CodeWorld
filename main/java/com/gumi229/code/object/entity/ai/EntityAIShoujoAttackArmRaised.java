package com.gumi229.code.object.entity.ai;

import com.gumi229.code.object.entity.EntityShoujo;

import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAIShoujoAttackArmRaised extends EntityAIAttackMelee {
	final EntityShoujo shoujo;
	int raiseArmTicks;

	public EntityAIShoujoAttackArmRaised(EntityShoujo shoujoIn, double speedIn, boolean useLongMemory) {
		super(shoujoIn, speedIn, useLongMemory);
		this.shoujo = shoujoIn;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	@Override
	public void resetTask() {
		super.resetTask();
		this.shoujo.setArmsRaised(false);
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	@Override
	public void updateTask() {
		super.updateTask();
		++this.raiseArmTicks;

		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.shoujo.setArmsRaised(true);
		} else {
			this.shoujo.setArmsRaised(false);
		}
	}

}
