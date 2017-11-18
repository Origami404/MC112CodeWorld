package com.gumi229.code.json;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapedRecipe {
	public static class ItemSign {
		String item;

		public String getItem() {
			return item;
		}

		public ItemSign(String item) {

			this.item = item;

		}

	}

	public static class Result {
		private String item;

		public Result(String item) {
			this.item = item;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}
	}

	private final String type = "forge:ore_shaped";
	private ArrayList<String> pattern = new ArrayList<>();
	private HashMap<String, ItemSign> key = new HashMap<>();
	private Result result;

	public String getType() {
		return type;
	}

	public ArrayList<String> getPattern() {
		return pattern;
	}

	public HashMap<String, ItemSign> getKey() {
		return key;
	}

	public Result getResult() {
		return result;
	}

	public ShapedRecipe(String result, String line1, String line2, String line3, String... sign) {
		pattern.add(line1);
		pattern.add(line2);
		pattern.add(line3);
		for (int i = 0; i < sign.length; i += 2) {
			key.put(sign[i], new ItemSign(sign[i + 1]));
		}

		this.result = new Result(result);
	}
}
