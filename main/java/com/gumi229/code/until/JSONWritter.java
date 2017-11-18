package com.gumi229.code.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.gumi229.code.json.ShapedRecipe;

import net.minecraft.item.Item;

public class JSONWritter {

	public static void writeJSONToFile(String fileName, String fileContent) throws IOException {
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

	public static boolean writeShapedRecipe(String result, String line1, String line2, String line3, String... sign) {
		String JSONPath = "D:\\MC\\Eclipse Oxy WorkSpace\\Model\\src\\main\\resources\\assets\\code_world\\recipes\\";
		boolean flag = true;
		try {
			String filePath = JSONPath + result.substring(11) + ".json";
			// String fileContent = buildJSON(result, line1, line2, line3, sign);

			ObjectMapper mapper = new ObjectMapper();
			ShapedRecipe shapedRecipe = new ShapedRecipe(result, line1, line2, line3, sign);
			writeJSONToFile(filePath, mapper.writeValueAsString(shapedRecipe));

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean writeShapedRecipe(Item item, String line1, String line2, String line3, String... sign) {
		return writeShapedRecipe(item.getRegistryName().toString(), line1, line2, line3, sign);
	}
}
