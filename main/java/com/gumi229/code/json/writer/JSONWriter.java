package com.gumi229.code.json.writer;

import com.gumi229.code.exception.CannotWriteJSONFile;
import com.gumi229.code.json.object.JSONObject;

public enum JSONWriter {
	Blockstates(new BlockstatesWritter()), ShapedRecipe(new ShapedRecipeWriter()), BlockModel(
			new BlockModelWriter()), ItemModel(new ItemModelWriter());

	private final JSONWritterBase writer;

	JSONWriter(JSONWritterBase w) {
		this.writer = w;
	}

	public void write(JSONObject o) throws CannotWriteJSONFile {
		writer.write(o);
	}
}

class BlockstatesWritter extends JSONWritterBase {

	@Override
	protected String getRelativePath() {
		return "blockstates";
	}
}

class ShapedRecipeWriter extends JSONWritterBase {

	@Override
	protected String getRelativePath() {
		return "recipes";
	}
}

class ItemModelWriter extends JSONWritterBase {

	@Override
	protected String getRelativePath() {
		return "models\\item";
	}

}

class BlockModelWriter extends JSONWritterBase {

	@Override
	protected String getRelativePath() {
		return "models\\block";
	}

}