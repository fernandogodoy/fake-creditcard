package com.github.fakecreditcard.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.fakecreditcard.Creditcard;
import com.github.fakecreditcard.FakeCard;
import com.github.fakecreditcard.validator.Luhn;

class FakeCardTest {

	private Luhn luhn = new Luhn();

	@Test
	void shouldReturnVisa() {
		Creditcard card = FakeCard.visa().createCard();
		assertTrue(luhn.isValid(card.getNumber()));
	}

	@Test
	void shouldReturnMaster() {
		Creditcard card = FakeCard.master().createCard();
		assertTrue(luhn.isValid(card.getNumber()));
	}

}
