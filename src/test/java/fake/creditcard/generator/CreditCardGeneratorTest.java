package fake.creditcard.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fake.creditcard.validator.Luhn;

class CreditCardGeneratorTest {

	private Luhn luhn;
	private CreditCardGenerator generator;

	@BeforeEach
	public void init() {
		luhn = new Luhn();
		generator = new CreditCardGenerator();
	}

	@Test
	void shouldReturnVisa() {
		String generate = generator.generate();
		assertTrue(luhn.isValid(generate));
	}

}
