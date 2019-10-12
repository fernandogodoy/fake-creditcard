package com.github.fakecreditcard.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.fakecreditcard.generator.Brand;
import com.github.fakecreditcard.generator.FakeCard;
import com.github.fakecreditcard.validator.Luhn;

class CreditCardGeneratorTest {

	private Luhn luhn;

	@BeforeEach
	public void init() {
		luhn = new Luhn();
	}

	@Test
	void shouldReturnVisa() {
		String generate = new FakeCard(Brand.VISA).create();
		assertTrue(luhn.isValid(generate));
	}

	@Test
	void shouldReturnMaster() {
		String generate = new FakeCard(Brand.MASTER).create();
		assertTrue(luhn.isValid(generate));
	}

}
