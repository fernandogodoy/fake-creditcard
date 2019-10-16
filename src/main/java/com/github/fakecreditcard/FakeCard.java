package com.github.fakecreditcard;

import com.github.fakecreditcard.generator.Brand;

public class FakeCard {

	private Brand brand;

	private FakeCard(Brand brand) {
		this.brand = brand;
	}

	public Creditcard createCard() {
		return Creditcard.builder()
				.number(brand.generate())
				.build();
	}

	public static FakeCard visa() {
		return new FakeCard(Brand.VISA);
	}

	public static FakeCard master() {
		return new FakeCard(Brand.MASTER);
	}

}
