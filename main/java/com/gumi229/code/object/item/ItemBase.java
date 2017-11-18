package com.gumi229.code.object.item;

import java.io.*;

import org.json.*;

import com.gumi229.code.exception.ShapedRecipeException;
import com.gumi229.code.until.Global;
<<<<<<< HEAD
import com.gumi229.code.until.ShapedRecipeJSONWritter;
=======
>>>>>>> 37db067039eb28b02a25da4efc0673323738a6db

import net.minecraft.item.Item;

public class ItemBase extends Item {
	public ItemBase() {
		
	}
	
	public ItemBase(String registryName, String line1, String line2, String line3, String... sign) {
		ShapedRecipeJSONWritter.write(registryName, line1, line2, line3, sign);
	}
}
