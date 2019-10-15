package io.github.fernandogodoy.fkcard.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.fernandogodoy.fkcard.generator.Brand;
import io.github.fernandogodoy.fkcard.generator.FakeCard;
import io.github.fernandogodoy.fkcard.validator.Luhn;

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
