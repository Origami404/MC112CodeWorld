package com.gumi229.code.object.item;

import net.minecraft.item.Item;

public class ShoujoIngot extends Item {

	public final ToolMaterial toolMaterial;
	public final float attack;
	public final float attackSpeech;

	public ShoujoIngot(float attack, float attackSpeech, ToolMaterial toolMaterial) {
		this.attack = attack;
		this.attackSpeech = attackSpeech;
		this.toolMaterial = toolMaterial;
	}

}
