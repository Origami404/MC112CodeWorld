package com.gumi229.code.object.group;

import com.gumi229.code.until.GroupInfo;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class GroupCode extends Group {
	private static final ToolMaterial material = EnumHelper.addToolMaterial("CODE", 4, 400, 8.0F, 2.0F, 7);
	private static final float hardness = 30.0f;
	private static final int harvestLevel = 4;

	public static GroupCode instance = null;

	public static GroupCode instance() {
		if (instance == null) {
			instance = new GroupCode();
		}
		return instance;
	}
	// ShapedRecipeJSONWritter.write("code_world:code_sword", " # ", " # ", " X ",
	// "#", "code_world:code_ingot",
	// "X", "minecraft:stick");

	public GroupCode() {
		super("code", new GroupInfo(hardness, harvestLevel, 5.0f, 4.0f, material));
	}
}
