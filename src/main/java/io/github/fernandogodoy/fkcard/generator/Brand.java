package io.github.fernandogodoy.fkcard.generator;

public enum Brand {

	VISA(new VisaCardGenerator()),
	MASTER(new MasterCardGenerator());

	private CreditCardGenerator generator;

	private Brand(CreditCardGenerator creditCardGenerator) {
		this.generator = creditCardGenerator;
	}

	CreditCardGenerator getGenerator() {
		return generator;
	}
}
