package com.gumi229.code.until;

public enum ProgrammingParadigm {
	OOP, FP, POP;

	private int toInt() {
		switch (this) {
		case OOP:
			return 0;
		case FP:
			return -1;
		case POP:
			return 1;

		}
		return -2;
	}

	public float getMultiple(ProgrammingParadigm target) {
		if (this.equals(target))
			return 1.0f;
		else if ((this.toInt() - target.toInt() == -1) || (this.toInt() - target.toInt() == 2))
			return 1.5f;
		else
			return 0.6f;
	}
}
