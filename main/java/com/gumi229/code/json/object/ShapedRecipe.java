package com.gumi229.code.json.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ShapedRecipe implements JSONObject {
	final String type = "forge:ore_shaped";
	final ArrayList<String> pattern;
	final Map<String, Map<String, String>> key;
	final Map<String, String> result;

	private ShapedRecipe(ArrayList<String> pattern, Map<String, Map<String, String>> key, Map<String, String> result) {
		super();
		this.pattern = pattern;
		this.key = key;
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public ArrayList<String> getPattern() {
		return pattern;
	}

	public Map<String, Map<String, String>> getKey() {
		return key;
	}

	public Map<String, String> getResult() {
		return result;
	}

	@Override
	public String makeFileName() {
		return result.get("item").substring(11) + ".json";
	}

	public static class Builder implements JSONObjectBuilder {
		ArrayList<String> pattern = new ArrayList<>();
		Map<String, Map<String, String>> key = new HashMap<>();
		Map<String, String> result = new HashMap<>();

		public Builder RecipePattern(String line1, String line2, String line3) {
			pattern.add(line1);
			pattern.add(line2);
			pattern.add(line3);
			return this;
		}

		public Builder RecipeKey(String... keys) {
			if (keys.length % 2 == 1)
				throw new IllegalArgumentException("Cannot match key");
			for (int i = 0; i < keys.length; i += 2) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("item", keys[i + 1]);
				this.key.put(keys[i], map);
			}
			return this;
		}

		public Builder RecipeResult(String name) {
			result.put("item", name);
			return this;
		}

		public Builder() {
		}

		@Override
		public JSONObject toJSONObject() {
			return new ShapedRecipe(pattern, key, result);
		}

	}
}
