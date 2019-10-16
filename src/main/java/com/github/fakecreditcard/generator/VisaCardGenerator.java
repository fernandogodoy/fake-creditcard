package com.github.fakecreditcard.generator;

public class VisaCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "4";
	}

	@Override
	protected int getFillDigitSum() {
		return 8;
	}

	@Override
	protected int maxRange() {
		return 14;
	}

	@Override
	protected boolean applyMultiplication(int index) {
		return index % 2 == 1;
	}

}
