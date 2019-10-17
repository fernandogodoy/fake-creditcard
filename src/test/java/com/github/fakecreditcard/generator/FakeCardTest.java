package com.github.fakecreditcard.generator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.fakecreditcard.FakeCard;
import com.github.fakecreditcard.data.Creditcard;
import com.github.fakecreditcard.validator.Luhn;

class FakeCardTest {

	private Luhn luhn = new Luhn();

	@Test
	void shouldReturnVisa() {
		Creditcard card = FakeCard.visa().createCard();
		assertNotNull(card.getNumber());
		assertTrue(luhn.isValid(card.getNumber()));
		assertNotNull(card.getHolderName());
		assertNotNull(card.getExpDate());
		assertNotNull(card.getCvv());
	}

	@Test
	void shouldReturnMaster() {
		Creditcard card = FakeCard.master().createCard();
		assertNotNull(card.getNumber());
		assertTrue(luhn.isValid(card.getNumber()));
		assertNotNull(card.getHolderName());
		assertNotNull(card.getExpDate());
		assertNotNull(card.getCvv());
	}

}
