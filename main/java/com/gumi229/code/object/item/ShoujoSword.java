package com.gumi229.code.object.item;

import java.util.HashSet;

import com.gumi229.code.until.ProgrammingParadigm;

<<<<<<< HEAD
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

public class ShoujoSword extends ItemTool {
	private Item ingot;
=======
import net.minecraft.item.ItemTool;

public class ShoujoSword extends ItemTool {
>>>>>>> 37db067039eb28b02a25da4efc0673323738a6db
	public final ProgrammingParadigm type;
	private int level = 0;

	public ShoujoSword(ShoujoIngot ingot, ProgrammingParadigm pp) {
		super(ingot.attack, ingot.attackSpeech, ingot.toolMaterial, new HashSet());
<<<<<<< HEAD
		this.ingot = ingot;
=======
>>>>>>> 37db067039eb28b02a25da4efc0673323738a6db
		this.type = pp;
	}

	public void addLevel(int i) {
		this.level += i;
	}

}
