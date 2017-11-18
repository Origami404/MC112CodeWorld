package com.gumi229.code.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gumi229.code.exception.ShapedRecipeException;

import net.minecraft.item.Item;

public class ShapedRecipeJSONWritter {
	public static final String JSONPath = "D:\\MC\\112SrcEclipse\\src\\main\\resources\\assets\\code_world\\recipes\\";

	public static void makeShapedRecipeJSON(String fileName, String fileContent) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();

			FileWriter fileWritter = new FileWriter(file, true);
			fileWritter.write(fileContent);
			Global.logger.info("Write ShapedRecipe JSON:{}", fileContent);
			Global.logger.info("In the file:{}", fileName);
			fileWritter.flush();
			fileWritter.close();
		}
	}

	public static String buildJSON(String result, String line1, String line2, String line3, String... sign)
			throws ShapedRecipeException {
		/*
		 * { "type": "forge:ore_shaped", "pattern": [ "X", "X", "#" ], "key": { "#": {
		 * "item": "minecraft:stick" }, "X": { "item": "code_world:data_ingot" } },
		 * "result": { "item": "code_world:data_sword" } }
		 */
		if (sign.length % 2 != 0) {
			throw new ShapedRecipeException("The sign must catch");
		}

		JSONObject json = new JSONObject();

		json.put("result", new JSONObject().put("item", result));

		// 添加key值对
		JSONObject keyArray = new JSONObject();
		for (int i = 0; i < sign.length; i += 2)
			keyArray.put(sign[i], new JSONObject().put("item", sign[i + 1]));
		json.put("key", keyArray);

		// 给pattern添加
		json.put("pattern", new JSONArray().put(line1).put(line2).put(line3));

		json.put("type", "forge:ore_shaped");

		return json.toString();
	}

	public static boolean write(String result, String line1, String line2, String line3, String... sign) {
		boolean flag = true;
		try {
			String filePath = JSONPath + result.substring(11) + ".json";
			String fileContent = buildJSON(result, line1, line2, line3, sign);

			makeShapedRecipeJSON(filePath, fileContent);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean write(Item item, String line1, String line2, String line3, String... sign) {
		return write(item.getRegistryName().toString(), line1, line2, line3, sign);
	}
}
