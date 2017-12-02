package com.gumi229.code.json.object;

import java.util.HashMap;

public final class ItemModel implements JSONObject {
	final String parent;
	HashMap<String, String> textures = new HashMap<>();

	public String getParent() {
		return parent;
	}

	public HashMap<String, String> getTextures() {
		return textures;
	}

	public ItemModel(String type, String itemRegistryName) {
		parent = type;
		textures.put("layer0", "code_world:items/" + itemRegistryName);
	}

	@Override
	public String makeFileName() {
		return textures.get("layer0").substring(17) + ".json";
	}

}
