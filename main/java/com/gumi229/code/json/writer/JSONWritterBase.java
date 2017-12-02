package com.gumi229.code.json.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.gumi229.code.exception.CannotWriteJSONFile;
import com.gumi229.code.json.object.JSONObject;
import com.gumi229.code.until.Global;

public abstract class JSONWritterBase {

	protected String getBasePath() {
		return "D:\\MC\\Eclipse Oxy WorkSpace\\Model\\src\\main\\resources\\assets\\code_world\\";
	}

	/**
	 * A method for subclass to override
	 * 
	 * @return A relative path to their mod's resources folder,like "D:\\MC\\Eclipse
	 *         Oxy WorkSpace\\Model\\src\\main\\resources\\assets\\code_world\\"
	 */
	protected abstract String getRelativePath();

	protected void writeJSONToFile(String filePathWithName, String fileContent) throws IOException {

		File file = new File(filePathWithName);
		Global.logger.debug("Test for path:", filePathWithName);
		if (!file.exists()) {
			file.createNewFile();

			FileWriter fileWriter = new FileWriter(file, false);
			fileWriter.write(fileContent);
			fileWriter.flush();
			fileWriter.close();
			Global.logger.info("Write ShapedRecipe JSON:{}", fileContent);
			Global.logger.info("In the file:{}", filePathWithName);
		} else {
			Global.logger.debug("Needn't write");
		}

	}

	public void write(JSONObject jsonObject) throws CannotWriteJSONFile {
		StringBuilder JSONPathBuilder = (new StringBuilder()).append(getBasePath()).append(getRelativePath())
				.append("\\").append(jsonObject.makeFileName());
		ObjectMapper mapper = new ObjectMapper();
		JSONFormater formater = new JSONFormater();
		try {
			writeJSONToFile(JSONPathBuilder.toString(), formater.formatJson(mapper.writeValueAsString(jsonObject)));
		} catch (IOException e) {
			e.printStackTrace();
			throw new CannotWriteJSONFile(this.getClass().getName(), jsonObject.makeFileName());
		}
	}

}
