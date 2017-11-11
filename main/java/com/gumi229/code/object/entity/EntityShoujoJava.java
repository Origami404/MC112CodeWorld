package com.gumi229.code.object.entity;

import com.gumi229.code.object.group.GroupCode;
import com.gumi229.code.until.Global;
import com.gumi229.code.until.ProgrammingParadigm;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityShoujoJava extends EntityShoujo {

	// public static final Entity instance = new EntityJavaShoujo(world);
	public EntityShoujoJava(World worldIn) {
		super(worldIn, ProgrammingParadigm.OOP);
		this.setSize(0.6F, 1.95F);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		super.dropFewItems(wasRecentlyHit, lootingModifier);
	}

	@Override
	protected Item getDropItem() {
		return GroupCode.instance().ingot;
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		Global.logger.info(this.getDropItem().getRegistryName().toString());
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		// this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
	}

}
