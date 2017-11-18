package com.gumi229.code.until;

import net.minecraft.item.Item.ToolMaterial;

public class GroupInfo {
	public final ToolMaterial toolMaterial;
	public final float oreHarfness;
	public final int harvestLevel;
	public final float toolAttack;
	public final float toolAttackSpeed;

	public GroupInfo(float oreHarfnessIn, int harvestLevelIn, float toolAttackIn, float toolAttackSpeedIn,
			ToolMaterial toolMaterialIn) {
		this.toolMaterial = toolMaterialIn;
		this.oreHarfness = oreHarfnessIn;
		this.harvestLevel = harvestLevelIn;
		this.toolAttack = toolAttackIn;
		this.toolAttackSpeed = toolAttackSpeedIn;
	}
}
