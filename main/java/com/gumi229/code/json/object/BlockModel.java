package com.gumi229.code.json.object;

import java.util.HashMap;

public final class BlockModel implements JSONObject {

	final String parent = "block/cube_all";
	HashMap<String, String> textures = new HashMap<>();

	public String getParent() {
		return parent;
	}

	public HashMap<String, String> getTextures() {
		return textures;
	}

	public BlockModel(String blockRegistryName) {
		String texturesPath = "code_world:blocks/";
		textures.put("all", texturesPath + blockRegistryName);
	}

	@Override
	public String makeFileName() {
		return textures.get("all").substring(18) + ".json";
	}

}
