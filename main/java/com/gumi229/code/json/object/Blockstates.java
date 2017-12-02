package com.gumi229.code.json.object;

import java.util.HashMap;

public final class Blockstates implements JSONObject {
	private HashMap<String, HashMap<String, String>> variants = new HashMap<>();

	public HashMap<String, HashMap<String, String>> getVariants() {
		return variants;
	}

	public Blockstates(String blockRegistryName) {
		HashMap<String, String> value = new HashMap<>();
		value.put("model", "code_world:" + blockRegistryName);
		this.variants.put("normal", value);
	}

	@Override
	public String makeFileName() {
		return variants.get("normal").get("model").substring(11) + ".json";
	}

}
