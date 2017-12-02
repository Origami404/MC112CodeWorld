package com.gumi229.code.json.object;

import com.gumi229.code.CodeWorld;

public class BlockItemModel implements JSONObject {
	final String parent;
	final String registryName;

	public BlockItemModel(String registryName) {
		this.parent = CodeWorld.MODID + ":block/" + registryName;
		this.registryName = registryName;
	}

	@Override
	public String makeFileName() {
		return registryName + ".json";
	}

	public String getParent() {
		return parent;
	}

}
