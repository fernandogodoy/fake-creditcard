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
	}

	@Test
	void shouldReturnVisa() {
		generator = new VisaCardGenerator();
		String generate = generator.generate();
		assertTrue(luhn.isValid(generate));
	}

	@Test
	void shouldReturnMaster() {
		generator = new MasterCardGenerator();
		String generate = generator.generate();
		assertTrue(luhn.isValid(generate));
	}

}
