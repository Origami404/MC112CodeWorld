package com.gumi229.code.object.item;

import com.gumi229.code.until.JSONWritter;

import net.minecraft.item.Item;

public class ItemBase extends Item {
	public ItemBase() {

	}

	public ItemBase(String registryName, String line1, String line2, String line3, String... sign) {
		JSONWritter.writeShapedRecipe(registryName, line1, line2, line3, sign);
	}
}
