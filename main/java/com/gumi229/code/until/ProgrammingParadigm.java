package com.gumi229.code.until;

public enum ProgrammingParadigm {
	/**
	 * DO NOT Change this ordinal!!!
	 */
	OOP, FP, POP;

	static float LESS = 0.6f;
	static float MORE = 1.5f;
	static float DRAW = 1.0f;

	static float[][] table = { { DRAW, LESS, MORE }, { MORE, DRAW, LESS }, { LESS, MORE, DRAW } };

	public float getMultiple(ProgrammingParadigm target) {
		return table[this.ordinal()][target.ordinal()];
	}
}
