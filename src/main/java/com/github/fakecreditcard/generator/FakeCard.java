package com.github.fakecreditcard.generator;

public class FakeCard {

	private Brand brand;

	public FakeCard(Brand brand) {
		this.brand = brand;
	}

	public String create() {
		return brand.getGenerator().generate();
	}

}
