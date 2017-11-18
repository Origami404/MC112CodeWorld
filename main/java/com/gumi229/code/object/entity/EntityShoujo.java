package com.gumi229.code.object.entity;

import com.gumi229.code.until.ProgrammingParadigm;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class EntityShoujo extends EntityZombie {
	public final ProgrammingParadigm type;

	public EntityShoujo(World worldIn, ProgrammingParadigm type) {
		super(worldIn);
		this.type = type;
	}

	@Override
	protected boolean shouldBurnInDay() {
		return false;
	}
}
