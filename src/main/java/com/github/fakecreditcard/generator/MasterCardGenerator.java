package com.github.fakecreditcard.generator;

public class MasterCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "5";
	}

	@Override
	protected int getFillDigitSum() {
		return 1;
	}

	@Override
	protected int maxRange() {
		return 13;
	}

	@Override
	protected boolean applyMultiplication(int index) {
		return index % 2 == 0;
	}

	@Override
	protected void before() {
		super.before();
		int digit = getRandomDigit();
		appendDigit(digit);
		sumDigit(digit);
	}

}
