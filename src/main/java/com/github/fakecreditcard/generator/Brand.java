package com.github.fakecreditcard.generator;

public enum Brand {

	VISA(new VisaCardGenerator()),
	MASTER(new MasterCardGenerator());

	private CreditCardGenerator generator;

	private Brand(CreditCardGenerator creditCardGenerator) {
		this.generator = creditCardGenerator;
	}

	public String generate() {
		return this.generator.generate();
	}
}
